package btljava.Dulieu;
import btljava.Dulieu.ThiSinh;
import java.util.Comparator;

public class SapXep implements Comparator<ThiSinh> {

    // sắp xếp thí sinh theo tuổi
 public int compare(ThiSinh o1, ThiSinh o2) {
  int age1 = o1.getMaThiSinh();
  int age2 = o2.getMaThiSinh();
  if(age1>age2){
   return 1;
  }else if(age1==age2){
   return 0;
  }else{
   return -1;
  }
 }}