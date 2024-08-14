package com.example.qradmin;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

    private List<AttendanceRecord> attendanceRecords;

    public AttendanceAdapter(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceRecord record = attendanceRecords.get(position);
        holder.studentNameTextView.setText(record.getStudentName());
        holder.dateTextView.setText(record.getDate());
        holder.statusTextView.setText(record.isPresent() ? "Present" : "Absent");
    }

    @Override
    public int getItemCount() {
        return attendanceRecords.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameTextView;
        TextView dateTextView;
        TextView statusTextView;

        ViewHolder(View itemView) {
            super(itemView);
            studentNameTextView = itemView.findViewById(R.id.studentNameTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
        }
    }
}
