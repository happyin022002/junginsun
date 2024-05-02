/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MTYCNTRPERFInDetailTrendVO.java
*@FileTitle : MTYCNTRPERFInDetailTrendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MTYCNTRPERFInDailyTrendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MTYCNTRPERFInDailyTrendVO> models = new ArrayList<MTYCNTRPERFInDailyTrendVO>();
	
	/* Column Info */
	private String sun09 = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String sun08 = null;
	/* Column Info */
	private String sun05 = null;
	/* Column Info */
	private String sun04 = null;
	/* Column Info */
	private String sun07 = null;
	/* Column Info */
	private String sun06 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sun01 = null;
	/* Column Info */
	private String sun02 = null;
	/* Column Info */
	private String sun03 = null;
	/* Column Info */
	private String wk = null;
	/* Column Info */
	private String sun16 = null;
	/* Column Info */
	private String sun17 = null;
	/* Column Info */
	private String sun15 = null;
	/* Column Info */
	private String sun13 = null;
	/* Column Info */
	private String sun14 = null;
	/* Column Info */
	private String sun11 = null;
	/* Column Info */
	private String sun12 = null;
	/* Column Info */
	private String sun10 = null;
	/* Column Info */
	private String tue15 = null;
	/* Column Info */
	private String tue16 = null;
	/* Column Info */
	private String tue17 = null;
	/* Column Info */
	private String fri02 = null;
	/* Column Info */
	private String fri01 = null;
	/* Column Info */
	private String tue11 = null;
	/* Column Info */
	private String tue12 = null;
	/* Column Info */
	private String tue13 = null;
	/* Column Info */
	private String tue14 = null;
	/* Column Info */
	private String mon02 = null;
	/* Column Info */
	private String mon03 = null;
	/* Column Info */
	private String mon01 = null;
	/* Column Info */
	private String tue10 = null;
	/* Column Info */
	private String mon07 = null;
	/* Column Info */
	private String mon06 = null;
	/* Column Info */
	private String mon05 = null;
	/* Column Info */
	private String mon04 = null;
	/* Column Info */
	private String sat12 = null;
	/* Column Info */
	private String sat11 = null;
	/* Column Info */
	private String sat10 = null;
	/* Column Info */
	private String mon09 = null;
	/* Column Info */
	private String mon08 = null;
	/* Column Info */
	private String sat16 = null;
	/* Column Info */
	private String sat17 = null;
	/* Column Info */
	private String sat15 = null;
	/* Column Info */
	private String sat14 = null;
	/* Column Info */
	private String sat13 = null;
	/* Column Info */
	private String tue08 = null;
	/* Column Info */
	private String tue09 = null;
	/* Column Info */
	private String fri13 = null;
	/* Column Info */
	private String tue06 = null;
	/* Column Info */
	private String fri12 = null;
	/* Column Info */
	private String tue07 = null;
	/* Column Info */
	private String fri11 = null;
	/* Column Info */
	private String tue04 = null;
	/* Column Info */
	private String fri10 = null;
	/* Column Info */
	private String tue05 = null;
	/* Column Info */
	private String tue02 = null;
	/* Column Info */
	private String tue03 = null;
	/* Column Info */
	private String mon10 = null;
	/* Column Info */
	private String tue01 = null;
	/* Column Info */
	private String mon11 = null;
	/* Column Info */
	private String mon12 = null;
	/* Column Info */
	private String mon13 = null;
	/* Column Info */
	private String mon14 = null;
	/* Column Info */
	private String mon16 = null;
	/* Column Info */
	private String mon17 = null;
	/* Column Info */
	private String mon15 = null;
	/* Column Info */
	private String fri05 = null;
	/* Column Info */
	private String fri06 = null;
	/* Column Info */
	private String fri03 = null;
	/* Column Info */
	private String fri04 = null;
	/* Column Info */
	private String fri09 = null;
	/* Column Info */
	private String fri07 = null;
	/* Column Info */
	private String fri08 = null;
	/* Column Info */
	private String thu16 = null;
	/* Column Info */
	private String thu17 = null;
	/* Column Info */
	private String wed03 = null;
	/* Column Info */
	private String wed02 = null;
	/* Column Info */
	private String thu14 = null;
	/* Column Info */
	private String wed05 = null;
	/* Column Info */
	private String thu15 = null;
	/* Column Info */
	private String wed04 = null;
	/* Column Info */
	private String wed07 = null;
	/* Column Info */
	private String thu12 = null;
	/* Column Info */
	private String wed06 = null;
	/* Column Info */
	private String thu13 = null;
	/* Column Info */
	private String wed09 = null;
	/* Column Info */
	private String thu10 = null;
	/* Column Info */
	private String wed08 = null;
	/* Column Info */
	private String thu11 = null;
	/* Column Info */
	private String wed01 = null;
	/* Column Info */
	private String fri14 = null;
	/* Column Info */
	private String fri15 = null;
	/* Column Info */
	private String fri16 = null;
	/* Column Info */
	private String fri17 = null;
	/* Column Info */
	private String wed16 = null;
	/* Column Info */
	private String wed17 = null;
	/* Column Info */
	private String thu03 = null;
	/* Column Info */
	private String wed15 = null;
	/* Column Info */
	private String thu04 = null;
	/* Column Info */
	private String wed14 = null;
	/* Column Info */
	private String thu05 = null;
	/* Column Info */
	private String wed13 = null;
	/* Column Info */
	private String thu06 = null;
	/* Column Info */
	private String thu01 = null;
	/* Column Info */
	private String thu02 = null;
	/* Column Info */
	private String wed12 = null;
	/* Column Info */
	private String thu07 = null;
	/* Column Info */
	private String wed11 = null;
	/* Column Info */
	private String thu08 = null;
	/* Column Info */
	private String wed10 = null;
	/* Column Info */
	private String thu09 = null;
	/* Column Info */
	private String sat06 = null;
	/* Column Info */
	private String sat07 = null;
	/* Column Info */
	private String sat08 = null;
	/* Column Info */
	private String sat09 = null;
	/* Column Info */
	private String sat02 = null;
	/* Column Info */
	private String sat03 = null;
	/* Column Info */
	private String sat04 = null;
	/* Column Info */
	private String sat05 = null;
	/* Column Info */
	private String sat01 = null;
	/* Column Info */
	private String count06 = null;
	/* Column Info */
	private String count05 = null;
	/* Column Info */
	private String count08 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String count07 = null;
	/* Column Info */
	private String count02 = null;
	/* Column Info */
	private String count01 = null;
	/* Column Info */
	private String count04 = null;
	/* Column Info */
	private String count03 = null;
	/* Column Info */
	private String count09 = null;
	/* Column Info */
	private String count10 = null;
	/* Column Info */
	private String count11 = null;
	/* Column Info */
	private String count16 = null;
	/* Column Info */
	private String count17 = null;
	/* Column Info */
	private String count15 = null;
	/* Column Info */
	private String count14 = null;
	/* Column Info */
	private String count13 = null;
	/* Column Info */
	private String count12 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MTYCNTRPERFInDailyTrendVO() {}

	public MTYCNTRPERFInDailyTrendVO(String ibflag, String pagerows, String wk, String total, String count01, String count02, String count03, String count04, String count05, String count06, String count07, String count08, String count09, String count10, String count11, String count12, String count13, String count14, String count15, String count16, String count17, String sun01, String sun02, String sun03, String sun04, String sun05, String sun06, String sun07, String sun08, String sun09, String sun10, String sun11, String sun12, String sun13, String sun14, String sun15, String sun16, String sun17, String mon01, String mon02, String mon03, String mon04, String mon05, String mon06, String mon07, String mon08, String mon09, String mon10, String mon11, String mon12, String mon13, String mon14, String mon15, String mon16, String mon17, String tue01, String tue02, String tue03, String tue04, String tue05, String tue06, String tue07, String tue08, String tue09, String tue10, String tue11, String tue12, String tue13, String tue14, String tue15, String tue16, String tue17, String wed01, String wed02, String wed03, String wed04, String wed05, String wed06, String wed07, String wed08, String wed09, String wed10, String wed11, String wed12, String wed13, String wed14, String wed15, String wed16, String wed17, String thu01, String thu02, String thu03, String thu04, String thu05, String thu06, String thu07, String thu08, String thu09, String thu10, String thu11, String thu12, String thu13, String thu14, String thu15, String thu16, String thu17, String fri01, String fri02, String fri03, String fri04, String fri05, String fri06, String fri07, String fri08, String fri09, String fri10, String fri11, String fri12, String fri13, String fri14, String fri15, String fri16, String fri17, String sat01, String sat02, String sat03, String sat04, String sat05, String sat06, String sat07, String sat08, String sat09, String sat10, String sat11, String sat12, String sat13, String sat14, String sat15, String sat16, String sat17) {
		this.sun09 = sun09;
		this.total = total;
		this.sun08 = sun08;
		this.sun05 = sun05;
		this.sun04 = sun04;
		this.sun07 = sun07;
		this.sun06 = sun06;
		this.pagerows = pagerows;
		this.sun01 = sun01;
		this.sun02 = sun02;
		this.sun03 = sun03;
		this.wk = wk;
		this.sun16 = sun16;
		this.sun17 = sun17;
		this.sun15 = sun15;
		this.sun13 = sun13;
		this.sun14 = sun14;
		this.sun11 = sun11;
		this.sun12 = sun12;
		this.sun10 = sun10;
		this.tue15 = tue15;
		this.tue16 = tue16;
		this.tue17 = tue17;
		this.fri02 = fri02;
		this.fri01 = fri01;
		this.tue11 = tue11;
		this.tue12 = tue12;
		this.tue13 = tue13;
		this.tue14 = tue14;
		this.mon02 = mon02;
		this.mon03 = mon03;
		this.mon01 = mon01;
		this.tue10 = tue10;
		this.mon07 = mon07;
		this.mon06 = mon06;
		this.mon05 = mon05;
		this.mon04 = mon04;
		this.sat12 = sat12;
		this.sat11 = sat11;
		this.sat10 = sat10;
		this.mon09 = mon09;
		this.mon08 = mon08;
		this.sat16 = sat16;
		this.sat17 = sat17;
		this.sat15 = sat15;
		this.sat14 = sat14;
		this.sat13 = sat13;
		this.tue08 = tue08;
		this.tue09 = tue09;
		this.fri13 = fri13;
		this.tue06 = tue06;
		this.fri12 = fri12;
		this.tue07 = tue07;
		this.fri11 = fri11;
		this.tue04 = tue04;
		this.fri10 = fri10;
		this.tue05 = tue05;
		this.tue02 = tue02;
		this.tue03 = tue03;
		this.mon10 = mon10;
		this.tue01 = tue01;
		this.mon11 = mon11;
		this.mon12 = mon12;
		this.mon13 = mon13;
		this.mon14 = mon14;
		this.mon16 = mon16;
		this.mon17 = mon17;
		this.mon15 = mon15;
		this.fri05 = fri05;
		this.fri06 = fri06;
		this.fri03 = fri03;
		this.fri04 = fri04;
		this.fri09 = fri09;
		this.fri07 = fri07;
		this.fri08 = fri08;
		this.thu16 = thu16;
		this.thu17 = thu17;
		this.wed03 = wed03;
		this.wed02 = wed02;
		this.thu14 = thu14;
		this.wed05 = wed05;
		this.thu15 = thu15;
		this.wed04 = wed04;
		this.wed07 = wed07;
		this.thu12 = thu12;
		this.wed06 = wed06;
		this.thu13 = thu13;
		this.wed09 = wed09;
		this.thu10 = thu10;
		this.wed08 = wed08;
		this.thu11 = thu11;
		this.wed01 = wed01;
		this.fri14 = fri14;
		this.fri15 = fri15;
		this.fri16 = fri16;
		this.fri17 = fri17;
		this.wed16 = wed16;
		this.wed17 = wed17;
		this.thu03 = thu03;
		this.wed15 = wed15;
		this.thu04 = thu04;
		this.wed14 = wed14;
		this.thu05 = thu05;
		this.wed13 = wed13;
		this.thu06 = thu06;
		this.thu01 = thu01;
		this.thu02 = thu02;
		this.wed12 = wed12;
		this.thu07 = thu07;
		this.wed11 = wed11;
		this.thu08 = thu08;
		this.wed10 = wed10;
		this.thu09 = thu09;
		this.sat06 = sat06;
		this.sat07 = sat07;
		this.sat08 = sat08;
		this.sat09 = sat09;
		this.sat02 = sat02;
		this.sat03 = sat03;
		this.sat04 = sat04;
		this.sat05 = sat05;
		this.sat01 = sat01;
		this.count06 = count06;
		this.count05 = count05;
		this.count08 = count08;
		this.ibflag = ibflag;
		this.count07 = count07;
		this.count02 = count02;
		this.count01 = count01;
		this.count04 = count04;
		this.count03 = count03;
		this.count09 = count09;
		this.count10 = count10;
		this.count11 = count11;
		this.count16 = count16;
		this.count17 = count17;
		this.count15 = count15;
		this.count14 = count14;
		this.count13 = count13;
		this.count12 = count12;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sun09", getSun09());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("sun08", getSun08());
		this.hashColumns.put("sun05", getSun05());
		this.hashColumns.put("sun04", getSun04());
		this.hashColumns.put("sun07", getSun07());
		this.hashColumns.put("sun06", getSun06());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sun01", getSun01());
		this.hashColumns.put("sun02", getSun02());
		this.hashColumns.put("sun03", getSun03());
		this.hashColumns.put("wk", getWk());
		this.hashColumns.put("sun16", getSun16());
		this.hashColumns.put("sun17", getSun17());
		this.hashColumns.put("sun15", getSun15());
		this.hashColumns.put("sun13", getSun13());
		this.hashColumns.put("sun14", getSun14());
		this.hashColumns.put("sun11", getSun11());
		this.hashColumns.put("sun12", getSun12());
		this.hashColumns.put("sun10", getSun10());
		this.hashColumns.put("tue15", getTue15());
		this.hashColumns.put("tue16", getTue16());
		this.hashColumns.put("tue17", getTue17());
		this.hashColumns.put("fri02", getFri02());
		this.hashColumns.put("fri01", getFri01());
		this.hashColumns.put("tue11", getTue11());
		this.hashColumns.put("tue12", getTue12());
		this.hashColumns.put("tue13", getTue13());
		this.hashColumns.put("tue14", getTue14());
		this.hashColumns.put("mon02", getMon02());
		this.hashColumns.put("mon03", getMon03());
		this.hashColumns.put("mon01", getMon01());
		this.hashColumns.put("tue10", getTue10());
		this.hashColumns.put("mon07", getMon07());
		this.hashColumns.put("mon06", getMon06());
		this.hashColumns.put("mon05", getMon05());
		this.hashColumns.put("mon04", getMon04());
		this.hashColumns.put("sat12", getSat12());
		this.hashColumns.put("sat11", getSat11());
		this.hashColumns.put("sat10", getSat10());
		this.hashColumns.put("mon09", getMon09());
		this.hashColumns.put("mon08", getMon08());
		this.hashColumns.put("sat16", getSat16());
		this.hashColumns.put("sat17", getSat17());
		this.hashColumns.put("sat15", getSat15());
		this.hashColumns.put("sat14", getSat14());
		this.hashColumns.put("sat13", getSat13());
		this.hashColumns.put("tue08", getTue08());
		this.hashColumns.put("tue09", getTue09());
		this.hashColumns.put("fri13", getFri13());
		this.hashColumns.put("tue06", getTue06());
		this.hashColumns.put("fri12", getFri12());
		this.hashColumns.put("tue07", getTue07());
		this.hashColumns.put("fri11", getFri11());
		this.hashColumns.put("tue04", getTue04());
		this.hashColumns.put("fri10", getFri10());
		this.hashColumns.put("tue05", getTue05());
		this.hashColumns.put("tue02", getTue02());
		this.hashColumns.put("tue03", getTue03());
		this.hashColumns.put("mon10", getMon10());
		this.hashColumns.put("tue01", getTue01());
		this.hashColumns.put("mon11", getMon11());
		this.hashColumns.put("mon12", getMon12());
		this.hashColumns.put("mon13", getMon13());
		this.hashColumns.put("mon14", getMon14());
		this.hashColumns.put("mon16", getMon16());
		this.hashColumns.put("mon17", getMon17());
		this.hashColumns.put("mon15", getMon15());
		this.hashColumns.put("fri05", getFri05());
		this.hashColumns.put("fri06", getFri06());
		this.hashColumns.put("fri03", getFri03());
		this.hashColumns.put("fri04", getFri04());
		this.hashColumns.put("fri09", getFri09());
		this.hashColumns.put("fri07", getFri07());
		this.hashColumns.put("fri08", getFri08());
		this.hashColumns.put("thu16", getThu16());
		this.hashColumns.put("thu17", getThu17());
		this.hashColumns.put("wed03", getWed03());
		this.hashColumns.put("wed02", getWed02());
		this.hashColumns.put("thu14", getThu14());
		this.hashColumns.put("wed05", getWed05());
		this.hashColumns.put("thu15", getThu15());
		this.hashColumns.put("wed04", getWed04());
		this.hashColumns.put("wed07", getWed07());
		this.hashColumns.put("thu12", getThu12());
		this.hashColumns.put("wed06", getWed06());
		this.hashColumns.put("thu13", getThu13());
		this.hashColumns.put("wed09", getWed09());
		this.hashColumns.put("thu10", getThu10());
		this.hashColumns.put("wed08", getWed08());
		this.hashColumns.put("thu11", getThu11());
		this.hashColumns.put("wed01", getWed01());
		this.hashColumns.put("fri14", getFri14());
		this.hashColumns.put("fri15", getFri15());
		this.hashColumns.put("fri16", getFri16());
		this.hashColumns.put("fri17", getFri17());
		this.hashColumns.put("wed16", getWed16());
		this.hashColumns.put("wed17", getWed17());
		this.hashColumns.put("thu03", getThu03());
		this.hashColumns.put("wed15", getWed15());
		this.hashColumns.put("thu04", getThu04());
		this.hashColumns.put("wed14", getWed14());
		this.hashColumns.put("thu05", getThu05());
		this.hashColumns.put("wed13", getWed13());
		this.hashColumns.put("thu06", getThu06());
		this.hashColumns.put("thu01", getThu01());
		this.hashColumns.put("thu02", getThu02());
		this.hashColumns.put("wed12", getWed12());
		this.hashColumns.put("thu07", getThu07());
		this.hashColumns.put("wed11", getWed11());
		this.hashColumns.put("thu08", getThu08());
		this.hashColumns.put("wed10", getWed10());
		this.hashColumns.put("thu09", getThu09());
		this.hashColumns.put("sat06", getSat06());
		this.hashColumns.put("sat07", getSat07());
		this.hashColumns.put("sat08", getSat08());
		this.hashColumns.put("sat09", getSat09());
		this.hashColumns.put("sat02", getSat02());
		this.hashColumns.put("sat03", getSat03());
		this.hashColumns.put("sat04", getSat04());
		this.hashColumns.put("sat05", getSat05());
		this.hashColumns.put("sat01", getSat01());
		this.hashColumns.put("count06", getCount06());
		this.hashColumns.put("count05", getCount05());
		this.hashColumns.put("count08", getCount08());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("count07", getCount07());
		this.hashColumns.put("count02", getCount02());
		this.hashColumns.put("count01", getCount01());
		this.hashColumns.put("count04", getCount04());
		this.hashColumns.put("count03", getCount03());
		this.hashColumns.put("count09", getCount09());
		this.hashColumns.put("count10", getCount10());
		this.hashColumns.put("count11", getCount11());
		this.hashColumns.put("count16", getCount16());
		this.hashColumns.put("count17", getCount17());
		this.hashColumns.put("count15", getCount15());
		this.hashColumns.put("count14", getCount14());
		this.hashColumns.put("count13", getCount13());
		this.hashColumns.put("count12", getCount12());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sun09", "sun09");
		this.hashFields.put("total", "total");
		this.hashFields.put("sun08", "sun08");
		this.hashFields.put("sun05", "sun05");
		this.hashFields.put("sun04", "sun04");
		this.hashFields.put("sun07", "sun07");
		this.hashFields.put("sun06", "sun06");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sun01", "sun01");
		this.hashFields.put("sun02", "sun02");
		this.hashFields.put("sun03", "sun03");
		this.hashFields.put("wk", "wk");
		this.hashFields.put("sun16", "sun16");
		this.hashFields.put("sun17", "sun17");
		this.hashFields.put("sun15", "sun15");
		this.hashFields.put("sun13", "sun13");
		this.hashFields.put("sun14", "sun14");
		this.hashFields.put("sun11", "sun11");
		this.hashFields.put("sun12", "sun12");
		this.hashFields.put("sun10", "sun10");
		this.hashFields.put("tue15", "tue15");
		this.hashFields.put("tue16", "tue16");
		this.hashFields.put("tue17", "tue17");
		this.hashFields.put("fri02", "fri02");
		this.hashFields.put("fri01", "fri01");
		this.hashFields.put("tue11", "tue11");
		this.hashFields.put("tue12", "tue12");
		this.hashFields.put("tue13", "tue13");
		this.hashFields.put("tue14", "tue14");
		this.hashFields.put("mon02", "mon02");
		this.hashFields.put("mon03", "mon03");
		this.hashFields.put("mon01", "mon01");
		this.hashFields.put("tue10", "tue10");
		this.hashFields.put("mon07", "mon07");
		this.hashFields.put("mon06", "mon06");
		this.hashFields.put("mon05", "mon05");
		this.hashFields.put("mon04", "mon04");
		this.hashFields.put("sat12", "sat12");
		this.hashFields.put("sat11", "sat11");
		this.hashFields.put("sat10", "sat10");
		this.hashFields.put("mon09", "mon09");
		this.hashFields.put("mon08", "mon08");
		this.hashFields.put("sat16", "sat16");
		this.hashFields.put("sat17", "sat17");
		this.hashFields.put("sat15", "sat15");
		this.hashFields.put("sat14", "sat14");
		this.hashFields.put("sat13", "sat13");
		this.hashFields.put("tue08", "tue08");
		this.hashFields.put("tue09", "tue09");
		this.hashFields.put("fri13", "fri13");
		this.hashFields.put("tue06", "tue06");
		this.hashFields.put("fri12", "fri12");
		this.hashFields.put("tue07", "tue07");
		this.hashFields.put("fri11", "fri11");
		this.hashFields.put("tue04", "tue04");
		this.hashFields.put("fri10", "fri10");
		this.hashFields.put("tue05", "tue05");
		this.hashFields.put("tue02", "tue02");
		this.hashFields.put("tue03", "tue03");
		this.hashFields.put("mon10", "mon10");
		this.hashFields.put("tue01", "tue01");
		this.hashFields.put("mon11", "mon11");
		this.hashFields.put("mon12", "mon12");
		this.hashFields.put("mon13", "mon13");
		this.hashFields.put("mon14", "mon14");
		this.hashFields.put("mon16", "mon16");
		this.hashFields.put("mon17", "mon17");
		this.hashFields.put("mon15", "mon15");
		this.hashFields.put("fri05", "fri05");
		this.hashFields.put("fri06", "fri06");
		this.hashFields.put("fri03", "fri03");
		this.hashFields.put("fri04", "fri04");
		this.hashFields.put("fri09", "fri09");
		this.hashFields.put("fri07", "fri07");
		this.hashFields.put("fri08", "fri08");
		this.hashFields.put("thu16", "thu16");
		this.hashFields.put("thu17", "thu17");
		this.hashFields.put("wed03", "wed03");
		this.hashFields.put("wed02", "wed02");
		this.hashFields.put("thu14", "thu14");
		this.hashFields.put("wed05", "wed05");
		this.hashFields.put("thu15", "thu15");
		this.hashFields.put("wed04", "wed04");
		this.hashFields.put("wed07", "wed07");
		this.hashFields.put("thu12", "thu12");
		this.hashFields.put("wed06", "wed06");
		this.hashFields.put("thu13", "thu13");
		this.hashFields.put("wed09", "wed09");
		this.hashFields.put("thu10", "thu10");
		this.hashFields.put("wed08", "wed08");
		this.hashFields.put("thu11", "thu11");
		this.hashFields.put("wed01", "wed01");
		this.hashFields.put("fri14", "fri14");
		this.hashFields.put("fri15", "fri15");
		this.hashFields.put("fri16", "fri16");
		this.hashFields.put("fri17", "fri17");
		this.hashFields.put("wed16", "wed16");
		this.hashFields.put("wed17", "wed17");
		this.hashFields.put("thu03", "thu03");
		this.hashFields.put("wed15", "wed15");
		this.hashFields.put("thu04", "thu04");
		this.hashFields.put("wed14", "wed14");
		this.hashFields.put("thu05", "thu05");
		this.hashFields.put("wed13", "wed13");
		this.hashFields.put("thu06", "thu06");
		this.hashFields.put("thu01", "thu01");
		this.hashFields.put("thu02", "thu02");
		this.hashFields.put("wed12", "wed12");
		this.hashFields.put("thu07", "thu07");
		this.hashFields.put("wed11", "wed11");
		this.hashFields.put("thu08", "thu08");
		this.hashFields.put("wed10", "wed10");
		this.hashFields.put("thu09", "thu09");
		this.hashFields.put("sat06", "sat06");
		this.hashFields.put("sat07", "sat07");
		this.hashFields.put("sat08", "sat08");
		this.hashFields.put("sat09", "sat09");
		this.hashFields.put("sat02", "sat02");
		this.hashFields.put("sat03", "sat03");
		this.hashFields.put("sat04", "sat04");
		this.hashFields.put("sat05", "sat05");
		this.hashFields.put("sat01", "sat01");
		this.hashFields.put("count06", "count06");
		this.hashFields.put("count05", "count05");
		this.hashFields.put("count08", "count08");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("count07", "count07");
		this.hashFields.put("count02", "count02");
		this.hashFields.put("count01", "count01");
		this.hashFields.put("count04", "count04");
		this.hashFields.put("count03", "count03");
		this.hashFields.put("count09", "count09");
		this.hashFields.put("count10", "count10");
		this.hashFields.put("count11", "count11");
		this.hashFields.put("count16", "count16");
		this.hashFields.put("count17", "count17");
		this.hashFields.put("count15", "count15");
		this.hashFields.put("count14", "count14");
		this.hashFields.put("count13", "count13");
		this.hashFields.put("count12", "count12");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sun09
	 */
	public String getSun09() {
		return this.sun09;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return sun08
	 */
	public String getSun08() {
		return this.sun08;
	}
	
	/**
	 * Column Info
	 * @return sun05
	 */
	public String getSun05() {
		return this.sun05;
	}
	
	/**
	 * Column Info
	 * @return sun04
	 */
	public String getSun04() {
		return this.sun04;
	}
	
	/**
	 * Column Info
	 * @return sun07
	 */
	public String getSun07() {
		return this.sun07;
	}
	
	/**
	 * Column Info
	 * @return sun06
	 */
	public String getSun06() {
		return this.sun06;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sun01
	 */
	public String getSun01() {
		return this.sun01;
	}
	
	/**
	 * Column Info
	 * @return sun02
	 */
	public String getSun02() {
		return this.sun02;
	}
	
	/**
	 * Column Info
	 * @return sun03
	 */
	public String getSun03() {
		return this.sun03;
	}
	
	/**
	 * Column Info
	 * @return wk
	 */
	public String getWk() {
		return this.wk;
	}
	
	/**
	 * Column Info
	 * @return sun16
	 */
	public String getSun16() {
		return this.sun16;
	}
	
	/**
	 * Column Info
	 * @return sun17
	 */
	public String getSun17() {
		return this.sun17;
	}
	
	/**
	 * Column Info
	 * @return sun15
	 */
	public String getSun15() {
		return this.sun15;
	}
	
	/**
	 * Column Info
	 * @return sun13
	 */
	public String getSun13() {
		return this.sun13;
	}
	
	/**
	 * Column Info
	 * @return sun14
	 */
	public String getSun14() {
		return this.sun14;
	}
	
	/**
	 * Column Info
	 * @return sun11
	 */
	public String getSun11() {
		return this.sun11;
	}
	
	/**
	 * Column Info
	 * @return sun12
	 */
	public String getSun12() {
		return this.sun12;
	}
	
	/**
	 * Column Info
	 * @return sun10
	 */
	public String getSun10() {
		return this.sun10;
	}
	
	/**
	 * Column Info
	 * @return tue15
	 */
	public String getTue15() {
		return this.tue15;
	}
	
	/**
	 * Column Info
	 * @return tue16
	 */
	public String getTue16() {
		return this.tue16;
	}
	
	/**
	 * Column Info
	 * @return tue17
	 */
	public String getTue17() {
		return this.tue17;
	}
	
	/**
	 * Column Info
	 * @return fri02
	 */
	public String getFri02() {
		return this.fri02;
	}
	
	/**
	 * Column Info
	 * @return fri01
	 */
	public String getFri01() {
		return this.fri01;
	}
	
	/**
	 * Column Info
	 * @return tue11
	 */
	public String getTue11() {
		return this.tue11;
	}
	
	/**
	 * Column Info
	 * @return tue12
	 */
	public String getTue12() {
		return this.tue12;
	}
	
	/**
	 * Column Info
	 * @return tue13
	 */
	public String getTue13() {
		return this.tue13;
	}
	
	/**
	 * Column Info
	 * @return tue14
	 */
	public String getTue14() {
		return this.tue14;
	}
	
	/**
	 * Column Info
	 * @return mon02
	 */
	public String getMon02() {
		return this.mon02;
	}
	
	/**
	 * Column Info
	 * @return mon03
	 */
	public String getMon03() {
		return this.mon03;
	}
	
	/**
	 * Column Info
	 * @return mon01
	 */
	public String getMon01() {
		return this.mon01;
	}
	
	/**
	 * Column Info
	 * @return tue10
	 */
	public String getTue10() {
		return this.tue10;
	}
	
	/**
	 * Column Info
	 * @return mon07
	 */
	public String getMon07() {
		return this.mon07;
	}
	
	/**
	 * Column Info
	 * @return mon06
	 */
	public String getMon06() {
		return this.mon06;
	}
	
	/**
	 * Column Info
	 * @return mon05
	 */
	public String getMon05() {
		return this.mon05;
	}
	
	/**
	 * Column Info
	 * @return mon04
	 */
	public String getMon04() {
		return this.mon04;
	}
	
	/**
	 * Column Info
	 * @return sat12
	 */
	public String getSat12() {
		return this.sat12;
	}
	
	/**
	 * Column Info
	 * @return sat11
	 */
	public String getSat11() {
		return this.sat11;
	}
	
	/**
	 * Column Info
	 * @return sat10
	 */
	public String getSat10() {
		return this.sat10;
	}
	
	/**
	 * Column Info
	 * @return mon09
	 */
	public String getMon09() {
		return this.mon09;
	}
	
	/**
	 * Column Info
	 * @return mon08
	 */
	public String getMon08() {
		return this.mon08;
	}
	
	/**
	 * Column Info
	 * @return sat16
	 */
	public String getSat16() {
		return this.sat16;
	}
	
	/**
	 * Column Info
	 * @return sat17
	 */
	public String getSat17() {
		return this.sat17;
	}
	
	/**
	 * Column Info
	 * @return sat15
	 */
	public String getSat15() {
		return this.sat15;
	}
	
	/**
	 * Column Info
	 * @return sat14
	 */
	public String getSat14() {
		return this.sat14;
	}
	
	/**
	 * Column Info
	 * @return sat13
	 */
	public String getSat13() {
		return this.sat13;
	}
	
	/**
	 * Column Info
	 * @return tue08
	 */
	public String getTue08() {
		return this.tue08;
	}
	
	/**
	 * Column Info
	 * @return tue09
	 */
	public String getTue09() {
		return this.tue09;
	}
	
	/**
	 * Column Info
	 * @return fri13
	 */
	public String getFri13() {
		return this.fri13;
	}
	
	/**
	 * Column Info
	 * @return tue06
	 */
	public String getTue06() {
		return this.tue06;
	}
	
	/**
	 * Column Info
	 * @return fri12
	 */
	public String getFri12() {
		return this.fri12;
	}
	
	/**
	 * Column Info
	 * @return tue07
	 */
	public String getTue07() {
		return this.tue07;
	}
	
	/**
	 * Column Info
	 * @return fri11
	 */
	public String getFri11() {
		return this.fri11;
	}
	
	/**
	 * Column Info
	 * @return tue04
	 */
	public String getTue04() {
		return this.tue04;
	}
	
	/**
	 * Column Info
	 * @return fri10
	 */
	public String getFri10() {
		return this.fri10;
	}
	
	/**
	 * Column Info
	 * @return tue05
	 */
	public String getTue05() {
		return this.tue05;
	}
	
	/**
	 * Column Info
	 * @return tue02
	 */
	public String getTue02() {
		return this.tue02;
	}
	
	/**
	 * Column Info
	 * @return tue03
	 */
	public String getTue03() {
		return this.tue03;
	}
	
	/**
	 * Column Info
	 * @return mon10
	 */
	public String getMon10() {
		return this.mon10;
	}
	
	/**
	 * Column Info
	 * @return tue01
	 */
	public String getTue01() {
		return this.tue01;
	}
	
	/**
	 * Column Info
	 * @return mon11
	 */
	public String getMon11() {
		return this.mon11;
	}
	
	/**
	 * Column Info
	 * @return mon12
	 */
	public String getMon12() {
		return this.mon12;
	}
	
	/**
	 * Column Info
	 * @return mon13
	 */
	public String getMon13() {
		return this.mon13;
	}
	
	/**
	 * Column Info
	 * @return mon14
	 */
	public String getMon14() {
		return this.mon14;
	}
	
	/**
	 * Column Info
	 * @return mon16
	 */
	public String getMon16() {
		return this.mon16;
	}
	
	/**
	 * Column Info
	 * @return mon17
	 */
	public String getMon17() {
		return this.mon17;
	}
	
	/**
	 * Column Info
	 * @return mon15
	 */
	public String getMon15() {
		return this.mon15;
	}
	
	/**
	 * Column Info
	 * @return fri05
	 */
	public String getFri05() {
		return this.fri05;
	}
	
	/**
	 * Column Info
	 * @return fri06
	 */
	public String getFri06() {
		return this.fri06;
	}
	
	/**
	 * Column Info
	 * @return fri03
	 */
	public String getFri03() {
		return this.fri03;
	}
	
	/**
	 * Column Info
	 * @return fri04
	 */
	public String getFri04() {
		return this.fri04;
	}
	
	/**
	 * Column Info
	 * @return fri09
	 */
	public String getFri09() {
		return this.fri09;
	}
	
	/**
	 * Column Info
	 * @return fri07
	 */
	public String getFri07() {
		return this.fri07;
	}
	
	/**
	 * Column Info
	 * @return fri08
	 */
	public String getFri08() {
		return this.fri08;
	}
	
	/**
	 * Column Info
	 * @return thu16
	 */
	public String getThu16() {
		return this.thu16;
	}
	
	/**
	 * Column Info
	 * @return thu17
	 */
	public String getThu17() {
		return this.thu17;
	}
	
	/**
	 * Column Info
	 * @return wed03
	 */
	public String getWed03() {
		return this.wed03;
	}
	
	/**
	 * Column Info
	 * @return wed02
	 */
	public String getWed02() {
		return this.wed02;
	}
	
	/**
	 * Column Info
	 * @return thu14
	 */
	public String getThu14() {
		return this.thu14;
	}
	
	/**
	 * Column Info
	 * @return wed05
	 */
	public String getWed05() {
		return this.wed05;
	}
	
	/**
	 * Column Info
	 * @return thu15
	 */
	public String getThu15() {
		return this.thu15;
	}
	
	/**
	 * Column Info
	 * @return wed04
	 */
	public String getWed04() {
		return this.wed04;
	}
	
	/**
	 * Column Info
	 * @return wed07
	 */
	public String getWed07() {
		return this.wed07;
	}
	
	/**
	 * Column Info
	 * @return thu12
	 */
	public String getThu12() {
		return this.thu12;
	}
	
	/**
	 * Column Info
	 * @return wed06
	 */
	public String getWed06() {
		return this.wed06;
	}
	
	/**
	 * Column Info
	 * @return thu13
	 */
	public String getThu13() {
		return this.thu13;
	}
	
	/**
	 * Column Info
	 * @return wed09
	 */
	public String getWed09() {
		return this.wed09;
	}
	
	/**
	 * Column Info
	 * @return thu10
	 */
	public String getThu10() {
		return this.thu10;
	}
	
	/**
	 * Column Info
	 * @return wed08
	 */
	public String getWed08() {
		return this.wed08;
	}
	
	/**
	 * Column Info
	 * @return thu11
	 */
	public String getThu11() {
		return this.thu11;
	}
	
	/**
	 * Column Info
	 * @return wed01
	 */
	public String getWed01() {
		return this.wed01;
	}
	
	/**
	 * Column Info
	 * @return fri14
	 */
	public String getFri14() {
		return this.fri14;
	}
	
	/**
	 * Column Info
	 * @return fri15
	 */
	public String getFri15() {
		return this.fri15;
	}
	
	/**
	 * Column Info
	 * @return fri16
	 */
	public String getFri16() {
		return this.fri16;
	}
	
	/**
	 * Column Info
	 * @return fri17
	 */
	public String getFri17() {
		return this.fri17;
	}
	
	/**
	 * Column Info
	 * @return wed16
	 */
	public String getWed16() {
		return this.wed16;
	}
	
	/**
	 * Column Info
	 * @return wed17
	 */
	public String getWed17() {
		return this.wed17;
	}
	
	/**
	 * Column Info
	 * @return thu03
	 */
	public String getThu03() {
		return this.thu03;
	}
	
	/**
	 * Column Info
	 * @return wed15
	 */
	public String getWed15() {
		return this.wed15;
	}
	
	/**
	 * Column Info
	 * @return thu04
	 */
	public String getThu04() {
		return this.thu04;
	}
	
	/**
	 * Column Info
	 * @return wed14
	 */
	public String getWed14() {
		return this.wed14;
	}
	
	/**
	 * Column Info
	 * @return thu05
	 */
	public String getThu05() {
		return this.thu05;
	}
	
	/**
	 * Column Info
	 * @return wed13
	 */
	public String getWed13() {
		return this.wed13;
	}
	
	/**
	 * Column Info
	 * @return thu06
	 */
	public String getThu06() {
		return this.thu06;
	}
	
	/**
	 * Column Info
	 * @return thu01
	 */
	public String getThu01() {
		return this.thu01;
	}
	
	/**
	 * Column Info
	 * @return thu02
	 */
	public String getThu02() {
		return this.thu02;
	}
	
	/**
	 * Column Info
	 * @return wed12
	 */
	public String getWed12() {
		return this.wed12;
	}
	
	/**
	 * Column Info
	 * @return thu07
	 */
	public String getThu07() {
		return this.thu07;
	}
	
	/**
	 * Column Info
	 * @return wed11
	 */
	public String getWed11() {
		return this.wed11;
	}
	
	/**
	 * Column Info
	 * @return thu08
	 */
	public String getThu08() {
		return this.thu08;
	}
	
	/**
	 * Column Info
	 * @return wed10
	 */
	public String getWed10() {
		return this.wed10;
	}
	
	/**
	 * Column Info
	 * @return thu09
	 */
	public String getThu09() {
		return this.thu09;
	}
	
	/**
	 * Column Info
	 * @return sat06
	 */
	public String getSat06() {
		return this.sat06;
	}
	
	/**
	 * Column Info
	 * @return sat07
	 */
	public String getSat07() {
		return this.sat07;
	}
	
	/**
	 * Column Info
	 * @return sat08
	 */
	public String getSat08() {
		return this.sat08;
	}
	
	/**
	 * Column Info
	 * @return sat09
	 */
	public String getSat09() {
		return this.sat09;
	}
	
	/**
	 * Column Info
	 * @return sat02
	 */
	public String getSat02() {
		return this.sat02;
	}
	
	/**
	 * Column Info
	 * @return sat03
	 */
	public String getSat03() {
		return this.sat03;
	}
	
	/**
	 * Column Info
	 * @return sat04
	 */
	public String getSat04() {
		return this.sat04;
	}
	
	/**
	 * Column Info
	 * @return sat05
	 */
	public String getSat05() {
		return this.sat05;
	}
	
	/**
	 * Column Info
	 * @return sat01
	 */
	public String getSat01() {
		return this.sat01;
	}
	
	/**
	 * Column Info
	 * @return count06
	 */
	public String getCount06() {
		return this.count06;
	}
	
	/**
	 * Column Info
	 * @return count05
	 */
	public String getCount05() {
		return this.count05;
	}
	
	/**
	 * Column Info
	 * @return count08
	 */
	public String getCount08() {
		return this.count08;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return count07
	 */
	public String getCount07() {
		return this.count07;
	}
	
	/**
	 * Column Info
	 * @return count02
	 */
	public String getCount02() {
		return this.count02;
	}
	
	/**
	 * Column Info
	 * @return count01
	 */
	public String getCount01() {
		return this.count01;
	}
	
	/**
	 * Column Info
	 * @return count04
	 */
	public String getCount04() {
		return this.count04;
	}
	
	/**
	 * Column Info
	 * @return count03
	 */
	public String getCount03() {
		return this.count03;
	}
	
	/**
	 * Column Info
	 * @return count09
	 */
	public String getCount09() {
		return this.count09;
	}
	
	/**
	 * Column Info
	 * @return count10
	 */
	public String getCount10() {
		return this.count10;
	}
	
	/**
	 * Column Info
	 * @return count11
	 */
	public String getCount11() {
		return this.count11;
	}
	
	/**
	 * Column Info
	 * @return count16
	 */
	public String getCount16() {
		return this.count16;
	}
	
	/**
	 * Column Info
	 * @return count17
	 */
	public String getCount17() {
		return this.count17;
	}
	
	/**
	 * Column Info
	 * @return count15
	 */
	public String getCount15() {
		return this.count15;
	}
	
	/**
	 * Column Info
	 * @return count14
	 */
	public String getCount14() {
		return this.count14;
	}
	
	/**
	 * Column Info
	 * @return count13
	 */
	public String getCount13() {
		return this.count13;
	}
	
	/**
	 * Column Info
	 * @return count12
	 */
	public String getCount12() {
		return this.count12;
	}
	

	/**
	 * Column Info
	 * @param sun09
	 */
	public void setSun09(String sun09) {
		this.sun09 = sun09;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param sun08
	 */
	public void setSun08(String sun08) {
		this.sun08 = sun08;
	}
	
	/**
	 * Column Info
	 * @param sun05
	 */
	public void setSun05(String sun05) {
		this.sun05 = sun05;
	}
	
	/**
	 * Column Info
	 * @param sun04
	 */
	public void setSun04(String sun04) {
		this.sun04 = sun04;
	}
	
	/**
	 * Column Info
	 * @param sun07
	 */
	public void setSun07(String sun07) {
		this.sun07 = sun07;
	}
	
	/**
	 * Column Info
	 * @param sun06
	 */
	public void setSun06(String sun06) {
		this.sun06 = sun06;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sun01
	 */
	public void setSun01(String sun01) {
		this.sun01 = sun01;
	}
	
	/**
	 * Column Info
	 * @param sun02
	 */
	public void setSun02(String sun02) {
		this.sun02 = sun02;
	}
	
	/**
	 * Column Info
	 * @param sun03
	 */
	public void setSun03(String sun03) {
		this.sun03 = sun03;
	}
	
	/**
	 * Column Info
	 * @param wk
	 */
	public void setWk(String wk) {
		this.wk = wk;
	}
	
	/**
	 * Column Info
	 * @param sun16
	 */
	public void setSun16(String sun16) {
		this.sun16 = sun16;
	}
	
	/**
	 * Column Info
	 * @param sun17
	 */
	public void setSun17(String sun17) {
		this.sun16 = sun17;
	}
	
	/**
	 * Column Info
	 * @param sun15
	 */
	public void setSun15(String sun15) {
		this.sun15 = sun15;
	}
	
	/**
	 * Column Info
	 * @param sun13
	 */
	public void setSun13(String sun13) {
		this.sun13 = sun13;
	}
	
	/**
	 * Column Info
	 * @param sun14
	 */
	public void setSun14(String sun14) {
		this.sun14 = sun14;
	}
	
	/**
	 * Column Info
	 * @param sun11
	 */
	public void setSun11(String sun11) {
		this.sun11 = sun11;
	}
	
	/**
	 * Column Info
	 * @param sun12
	 */
	public void setSun12(String sun12) {
		this.sun12 = sun12;
	}
	
	/**
	 * Column Info
	 * @param sun10
	 */
	public void setSun10(String sun10) {
		this.sun10 = sun10;
	}
	
	/**
	 * Column Info
	 * @param tue15
	 */
	public void setTue15(String tue15) {
		this.tue15 = tue15;
	}
	
	/**
	 * Column Info
	 * @param tue16
	 */
	public void setTue16(String tue16) {
		this.tue16 = tue16;
	}
	
	/**
	 * Column Info
	 * @param tue17
	 */
	public void setTue17(String tue17) {
		this.tue16 = tue17;
	}
	
	/**
	 * Column Info
	 * @param fri02
	 */
	public void setFri02(String fri02) {
		this.fri02 = fri02;
	}
	
	/**
	 * Column Info
	 * @param fri01
	 */
	public void setFri01(String fri01) {
		this.fri01 = fri01;
	}
	
	/**
	 * Column Info
	 * @param tue11
	 */
	public void setTue11(String tue11) {
		this.tue11 = tue11;
	}
	
	/**
	 * Column Info
	 * @param tue12
	 */
	public void setTue12(String tue12) {
		this.tue12 = tue12;
	}
	
	/**
	 * Column Info
	 * @param tue13
	 */
	public void setTue13(String tue13) {
		this.tue13 = tue13;
	}
	
	/**
	 * Column Info
	 * @param tue14
	 */
	public void setTue14(String tue14) {
		this.tue14 = tue14;
	}
	
	/**
	 * Column Info
	 * @param mon02
	 */
	public void setMon02(String mon02) {
		this.mon02 = mon02;
	}
	
	/**
	 * Column Info
	 * @param mon03
	 */
	public void setMon03(String mon03) {
		this.mon03 = mon03;
	}
	
	/**
	 * Column Info
	 * @param mon01
	 */
	public void setMon01(String mon01) {
		this.mon01 = mon01;
	}
	
	/**
	 * Column Info
	 * @param tue10
	 */
	public void setTue10(String tue10) {
		this.tue10 = tue10;
	}
	
	/**
	 * Column Info
	 * @param mon07
	 */
	public void setMon07(String mon07) {
		this.mon07 = mon07;
	}
	
	/**
	 * Column Info
	 * @param mon06
	 */
	public void setMon06(String mon06) {
		this.mon06 = mon06;
	}
	
	/**
	 * Column Info
	 * @param mon05
	 */
	public void setMon05(String mon05) {
		this.mon05 = mon05;
	}
	
	/**
	 * Column Info
	 * @param mon04
	 */
	public void setMon04(String mon04) {
		this.mon04 = mon04;
	}
	
	/**
	 * Column Info
	 * @param sat12
	 */
	public void setSat12(String sat12) {
		this.sat12 = sat12;
	}
	
	/**
	 * Column Info
	 * @param sat11
	 */
	public void setSat11(String sat11) {
		this.sat11 = sat11;
	}
	
	/**
	 * Column Info
	 * @param sat10
	 */
	public void setSat10(String sat10) {
		this.sat10 = sat10;
	}
	
	/**
	 * Column Info
	 * @param mon09
	 */
	public void setMon09(String mon09) {
		this.mon09 = mon09;
	}
	
	/**
	 * Column Info
	 * @param mon08
	 */
	public void setMon08(String mon08) {
		this.mon08 = mon08;
	}
	
	/**
	 * Column Info
	 * @param sat16
	 */
	public void setSat16(String sat16) {
		this.sat16 = sat16;
	}
	
	/**
	 * Column Info
	 * @param sat17
	 */
	public void setSat17(String sat17) {
		this.sat17 = sat17;
	}
	
	/**
	 * Column Info
	 * @param sat15
	 */
	public void setSat15(String sat15) {
		this.sat15 = sat15;
	}
	
	/**
	 * Column Info
	 * @param sat14
	 */
	public void setSat14(String sat14) {
		this.sat14 = sat14;
	}
	
	/**
	 * Column Info
	 * @param sat13
	 */
	public void setSat13(String sat13) {
		this.sat13 = sat13;
	}
	
	/**
	 * Column Info
	 * @param tue08
	 */
	public void setTue08(String tue08) {
		this.tue08 = tue08;
	}
	
	/**
	 * Column Info
	 * @param tue09
	 */
	public void setTue09(String tue09) {
		this.tue09 = tue09;
	}
	
	/**
	 * Column Info
	 * @param fri13
	 */
	public void setFri13(String fri13) {
		this.fri13 = fri13;
	}
	
	/**
	 * Column Info
	 * @param tue06
	 */
	public void setTue06(String tue06) {
		this.tue06 = tue06;
	}
	
	/**
	 * Column Info
	 * @param fri12
	 */
	public void setFri12(String fri12) {
		this.fri12 = fri12;
	}
	
	/**
	 * Column Info
	 * @param tue07
	 */
	public void setTue07(String tue07) {
		this.tue07 = tue07;
	}
	
	/**
	 * Column Info
	 * @param fri11
	 */
	public void setFri11(String fri11) {
		this.fri11 = fri11;
	}
	
	/**
	 * Column Info
	 * @param tue04
	 */
	public void setTue04(String tue04) {
		this.tue04 = tue04;
	}
	
	/**
	 * Column Info
	 * @param fri10
	 */
	public void setFri10(String fri10) {
		this.fri10 = fri10;
	}
	
	/**
	 * Column Info
	 * @param tue05
	 */
	public void setTue05(String tue05) {
		this.tue05 = tue05;
	}
	
	/**
	 * Column Info
	 * @param tue02
	 */
	public void setTue02(String tue02) {
		this.tue02 = tue02;
	}
	
	/**
	 * Column Info
	 * @param tue03
	 */
	public void setTue03(String tue03) {
		this.tue03 = tue03;
	}
	
	/**
	 * Column Info
	 * @param mon10
	 */
	public void setMon10(String mon10) {
		this.mon10 = mon10;
	}
	
	/**
	 * Column Info
	 * @param tue01
	 */
	public void setTue01(String tue01) {
		this.tue01 = tue01;
	}
	
	/**
	 * Column Info
	 * @param mon11
	 */
	public void setMon11(String mon11) {
		this.mon11 = mon11;
	}
	
	/**
	 * Column Info
	 * @param mon12
	 */
	public void setMon12(String mon12) {
		this.mon12 = mon12;
	}
	
	/**
	 * Column Info
	 * @param mon13
	 */
	public void setMon13(String mon13) {
		this.mon13 = mon13;
	}
	
	/**
	 * Column Info
	 * @param mon14
	 */
	public void setMon14(String mon14) {
		this.mon14 = mon14;
	}
	
	/**
	 * Column Info
	 * @param mon16
	 */
	public void setMon16(String mon16) {
		this.mon16 = mon16;
	}
	
	/**
	 * Column Info
	 * @param mon17
	 */
	public void setMon17(String mon17) {
		this.mon17 = mon17;
	}
	
	/**
	 * Column Info
	 * @param mon15
	 */
	public void setMon15(String mon15) {
		this.mon15 = mon15;
	}
	
	/**
	 * Column Info
	 * @param fri05
	 */
	public void setFri05(String fri05) {
		this.fri05 = fri05;
	}
	
	/**
	 * Column Info
	 * @param fri06
	 */
	public void setFri06(String fri06) {
		this.fri06 = fri06;
	}
	
	/**
	 * Column Info
	 * @param fri03
	 */
	public void setFri03(String fri03) {
		this.fri03 = fri03;
	}
	
	/**
	 * Column Info
	 * @param fri04
	 */
	public void setFri04(String fri04) {
		this.fri04 = fri04;
	}
	
	/**
	 * Column Info
	 * @param fri09
	 */
	public void setFri09(String fri09) {
		this.fri09 = fri09;
	}
	
	/**
	 * Column Info
	 * @param fri07
	 */
	public void setFri07(String fri07) {
		this.fri07 = fri07;
	}
	
	/**
	 * Column Info
	 * @param fri08
	 */
	public void setFri08(String fri08) {
		this.fri08 = fri08;
	}
	
	/**
	 * Column Info
	 * @param thu16
	 */
	public void setThu16(String thu16) {
		this.thu16 = thu16;
	}
	
	/**
	 * Column Info
	 * @param thu16
	 */
	public void setThu17(String thu17) {
		this.thu17 = thu17;
	}
	
	/**
	 * Column Info
	 * @param wed03
	 */
	public void setWed03(String wed03) {
		this.wed03 = wed03;
	}
	
	/**
	 * Column Info
	 * @param wed02
	 */
	public void setWed02(String wed02) {
		this.wed02 = wed02;
	}
	
	/**
	 * Column Info
	 * @param thu14
	 */
	public void setThu14(String thu14) {
		this.thu14 = thu14;
	}
	
	/**
	 * Column Info
	 * @param wed05
	 */
	public void setWed05(String wed05) {
		this.wed05 = wed05;
	}
	
	/**
	 * Column Info
	 * @param thu15
	 */
	public void setThu15(String thu15) {
		this.thu15 = thu15;
	}
	
	/**
	 * Column Info
	 * @param wed04
	 */
	public void setWed04(String wed04) {
		this.wed04 = wed04;
	}
	
	/**
	 * Column Info
	 * @param wed07
	 */
	public void setWed07(String wed07) {
		this.wed07 = wed07;
	}
	
	/**
	 * Column Info
	 * @param thu12
	 */
	public void setThu12(String thu12) {
		this.thu12 = thu12;
	}
	
	/**
	 * Column Info
	 * @param wed06
	 */
	public void setWed06(String wed06) {
		this.wed06 = wed06;
	}
	
	/**
	 * Column Info
	 * @param thu13
	 */
	public void setThu13(String thu13) {
		this.thu13 = thu13;
	}
	
	/**
	 * Column Info
	 * @param wed09
	 */
	public void setWed09(String wed09) {
		this.wed09 = wed09;
	}
	
	/**
	 * Column Info
	 * @param thu10
	 */
	public void setThu10(String thu10) {
		this.thu10 = thu10;
	}
	
	/**
	 * Column Info
	 * @param wed08
	 */
	public void setWed08(String wed08) {
		this.wed08 = wed08;
	}
	
	/**
	 * Column Info
	 * @param thu11
	 */
	public void setThu11(String thu11) {
		this.thu11 = thu11;
	}
	
	/**
	 * Column Info
	 * @param wed01
	 */
	public void setWed01(String wed01) {
		this.wed01 = wed01;
	}
	
	/**
	 * Column Info
	 * @param fri14
	 */
	public void setFri14(String fri14) {
		this.fri14 = fri14;
	}
	
	/**
	 * Column Info
	 * @param fri15
	 */
	public void setFri15(String fri15) {
		this.fri15 = fri15;
	}
	
	/**
	 * Column Info
	 * @param fri16
	 */
	public void setFri16(String fri16) {
		this.fri16 = fri16;
	}
	
	/**
	 * Column Info
	 * @param fri17
	 */
	public void setFri17(String fri17) {
		this.fri17 = fri17;
	}
	
	/**
	 * Column Info
	 * @param wed16
	 */
	public void setWed16(String wed16) {
		this.wed16 = wed16;
	}
	
	/**
	 * Column Info
	 * @param wed17
	 */
	public void setWed17(String wed17) {
		this.wed17 = wed17;
	}
	
	/**
	 * Column Info
	 * @param thu03
	 */
	public void setThu03(String thu03) {
		this.thu03 = thu03;
	}
	
	/**
	 * Column Info
	 * @param wed15
	 */
	public void setWed15(String wed15) {
		this.wed15 = wed15;
	}
	
	/**
	 * Column Info
	 * @param thu04
	 */
	public void setThu04(String thu04) {
		this.thu04 = thu04;
	}
	
	/**
	 * Column Info
	 * @param wed14
	 */
	public void setWed14(String wed14) {
		this.wed14 = wed14;
	}
	
	/**
	 * Column Info
	 * @param thu05
	 */
	public void setThu05(String thu05) {
		this.thu05 = thu05;
	}
	
	/**
	 * Column Info
	 * @param wed13
	 */
	public void setWed13(String wed13) {
		this.wed13 = wed13;
	}
	
	/**
	 * Column Info
	 * @param thu06
	 */
	public void setThu06(String thu06) {
		this.thu06 = thu06;
	}
	
	/**
	 * Column Info
	 * @param thu01
	 */
	public void setThu01(String thu01) {
		this.thu01 = thu01;
	}
	
	/**
	 * Column Info
	 * @param thu02
	 */
	public void setThu02(String thu02) {
		this.thu02 = thu02;
	}
	
	/**
	 * Column Info
	 * @param wed12
	 */
	public void setWed12(String wed12) {
		this.wed12 = wed12;
	}
	
	/**
	 * Column Info
	 * @param thu07
	 */
	public void setThu07(String thu07) {
		this.thu07 = thu07;
	}
	
	/**
	 * Column Info
	 * @param wed11
	 */
	public void setWed11(String wed11) {
		this.wed11 = wed11;
	}
	
	/**
	 * Column Info
	 * @param thu08
	 */
	public void setThu08(String thu08) {
		this.thu08 = thu08;
	}
	
	/**
	 * Column Info
	 * @param wed10
	 */
	public void setWed10(String wed10) {
		this.wed10 = wed10;
	}
	
	/**
	 * Column Info
	 * @param thu09
	 */
	public void setThu09(String thu09) {
		this.thu09 = thu09;
	}
	
	/**
	 * Column Info
	 * @param sat06
	 */
	public void setSat06(String sat06) {
		this.sat06 = sat06;
	}
	
	/**
	 * Column Info
	 * @param sat07
	 */
	public void setSat07(String sat07) {
		this.sat07 = sat07;
	}
	
	/**
	 * Column Info
	 * @param sat08
	 */
	public void setSat08(String sat08) {
		this.sat08 = sat08;
	}
	
	/**
	 * Column Info
	 * @param sat09
	 */
	public void setSat09(String sat09) {
		this.sat09 = sat09;
	}
	
	/**
	 * Column Info
	 * @param sat02
	 */
	public void setSat02(String sat02) {
		this.sat02 = sat02;
	}
	
	/**
	 * Column Info
	 * @param sat03
	 */
	public void setSat03(String sat03) {
		this.sat03 = sat03;
	}
	
	/**
	 * Column Info
	 * @param sat04
	 */
	public void setSat04(String sat04) {
		this.sat04 = sat04;
	}
	
	/**
	 * Column Info
	 * @param sat05
	 */
	public void setSat05(String sat05) {
		this.sat05 = sat05;
	}
	
	/**
	 * Column Info
	 * @param sat01
	 */
	public void setSat01(String sat01) {
		this.sat01 = sat01;
	}
	
	/**
	 * Column Info
	 * @param count06
	 */
	public void setCount06(String count06) {
		this.count06 = count06;
	}
	
	/**
	 * Column Info
	 * @param count05
	 */
	public void setCount05(String count05) {
		this.count05 = count05;
	}
	
	/**
	 * Column Info
	 * @param count08
	 */
	public void setCount08(String count08) {
		this.count08 = count08;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param count07
	 */
	public void setCount07(String count07) {
		this.count07 = count07;
	}
	
	/**
	 * Column Info
	 * @param count02
	 */
	public void setCount02(String count02) {
		this.count02 = count02;
	}
	
	/**
	 * Column Info
	 * @param count01
	 */
	public void setCount01(String count01) {
		this.count01 = count01;
	}
	
	/**
	 * Column Info
	 * @param count04
	 */
	public void setCount04(String count04) {
		this.count04 = count04;
	}
	
	/**
	 * Column Info
	 * @param count03
	 */
	public void setCount03(String count03) {
		this.count03 = count03;
	}
	
	/**
	 * Column Info
	 * @param count09
	 */
	public void setCount09(String count09) {
		this.count09 = count09;
	}
	
	/**
	 * Column Info
	 * @param count10
	 */
	public void setCount10(String count10) {
		this.count10 = count10;
	}
	
	/**
	 * Column Info
	 * @param count11
	 */
	public void setCount11(String count11) {
		this.count11 = count11;
	}
	
	/**
	 * Column Info
	 * @param count16
	 */
	public void setCount16(String count16) {
		this.count16 = count16;
	}
	
	/**
	 * Column Info
	 * @param count17
	 */
	public void setCount17(String count17) {
		this.count17 = count17;
	}
	
	/**
	 * Column Info
	 * @param count15
	 */
	public void setCount15(String count15) {
		this.count15 = count15;
	}
	
	/**
	 * Column Info
	 * @param count14
	 */
	public void setCount14(String count14) {
		this.count14 = count14;
	}
	
	/**
	 * Column Info
	 * @param count13
	 */
	public void setCount13(String count13) {
		this.count13 = count13;
	}
	
	/**
	 * Column Info
	 * @param count12
	 */
	public void setCount12(String count12) {
		this.count12 = count12;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSun09(JSPUtil.getParameter(request, prefix + "sun09", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setSun08(JSPUtil.getParameter(request, prefix + "sun08", ""));
		setSun05(JSPUtil.getParameter(request, prefix + "sun05", ""));
		setSun04(JSPUtil.getParameter(request, prefix + "sun04", ""));
		setSun07(JSPUtil.getParameter(request, prefix + "sun07", ""));
		setSun06(JSPUtil.getParameter(request, prefix + "sun06", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSun01(JSPUtil.getParameter(request, prefix + "sun01", ""));
		setSun02(JSPUtil.getParameter(request, prefix + "sun02", ""));
		setSun03(JSPUtil.getParameter(request, prefix + "sun03", ""));
		setWk(JSPUtil.getParameter(request, prefix + "wk", ""));
		setSun16(JSPUtil.getParameter(request, prefix + "sun16", ""));
		setSun17(JSPUtil.getParameter(request, prefix + "sun17", ""));
		setSun15(JSPUtil.getParameter(request, prefix + "sun15", ""));
		setSun13(JSPUtil.getParameter(request, prefix + "sun13", ""));
		setSun14(JSPUtil.getParameter(request, prefix + "sun14", ""));
		setSun11(JSPUtil.getParameter(request, prefix + "sun11", ""));
		setSun12(JSPUtil.getParameter(request, prefix + "sun12", ""));
		setSun10(JSPUtil.getParameter(request, prefix + "sun10", ""));
		setTue15(JSPUtil.getParameter(request, prefix + "tue15", ""));
		setTue16(JSPUtil.getParameter(request, prefix + "tue16", ""));
		setTue17(JSPUtil.getParameter(request, prefix + "tue17", ""));
		setFri02(JSPUtil.getParameter(request, prefix + "fri02", ""));
		setFri01(JSPUtil.getParameter(request, prefix + "fri01", ""));
		setTue11(JSPUtil.getParameter(request, prefix + "tue11", ""));
		setTue12(JSPUtil.getParameter(request, prefix + "tue12", ""));
		setTue13(JSPUtil.getParameter(request, prefix + "tue13", ""));
		setTue14(JSPUtil.getParameter(request, prefix + "tue14", ""));
		setMon02(JSPUtil.getParameter(request, prefix + "mon02", ""));
		setMon03(JSPUtil.getParameter(request, prefix + "mon03", ""));
		setMon01(JSPUtil.getParameter(request, prefix + "mon01", ""));
		setTue10(JSPUtil.getParameter(request, prefix + "tue10", ""));
		setMon07(JSPUtil.getParameter(request, prefix + "mon07", ""));
		setMon06(JSPUtil.getParameter(request, prefix + "mon06", ""));
		setMon05(JSPUtil.getParameter(request, prefix + "mon05", ""));
		setMon04(JSPUtil.getParameter(request, prefix + "mon04", ""));
		setSat12(JSPUtil.getParameter(request, prefix + "sat12", ""));
		setSat11(JSPUtil.getParameter(request, prefix + "sat11", ""));
		setSat10(JSPUtil.getParameter(request, prefix + "sat10", ""));
		setMon09(JSPUtil.getParameter(request, prefix + "mon09", ""));
		setMon08(JSPUtil.getParameter(request, prefix + "mon08", ""));
		setSat16(JSPUtil.getParameter(request, prefix + "sat16", ""));
		setSat17(JSPUtil.getParameter(request, prefix + "sat17", ""));
		setSat15(JSPUtil.getParameter(request, prefix + "sat15", ""));
		setSat14(JSPUtil.getParameter(request, prefix + "sat14", ""));
		setSat13(JSPUtil.getParameter(request, prefix + "sat13", ""));
		setTue08(JSPUtil.getParameter(request, prefix + "tue08", ""));
		setTue09(JSPUtil.getParameter(request, prefix + "tue09", ""));
		setFri13(JSPUtil.getParameter(request, prefix + "fri13", ""));
		setTue06(JSPUtil.getParameter(request, prefix + "tue06", ""));
		setFri12(JSPUtil.getParameter(request, prefix + "fri12", ""));
		setTue07(JSPUtil.getParameter(request, prefix + "tue07", ""));
		setFri11(JSPUtil.getParameter(request, prefix + "fri11", ""));
		setTue04(JSPUtil.getParameter(request, prefix + "tue04", ""));
		setFri10(JSPUtil.getParameter(request, prefix + "fri10", ""));
		setTue05(JSPUtil.getParameter(request, prefix + "tue05", ""));
		setTue02(JSPUtil.getParameter(request, prefix + "tue02", ""));
		setTue03(JSPUtil.getParameter(request, prefix + "tue03", ""));
		setMon10(JSPUtil.getParameter(request, prefix + "mon10", ""));
		setTue01(JSPUtil.getParameter(request, prefix + "tue01", ""));
		setMon11(JSPUtil.getParameter(request, prefix + "mon11", ""));
		setMon12(JSPUtil.getParameter(request, prefix + "mon12", ""));
		setMon13(JSPUtil.getParameter(request, prefix + "mon13", ""));
		setMon14(JSPUtil.getParameter(request, prefix + "mon14", ""));
		setMon16(JSPUtil.getParameter(request, prefix + "mon16", ""));
		setMon17(JSPUtil.getParameter(request, prefix + "mon17", ""));
		setMon15(JSPUtil.getParameter(request, prefix + "mon15", ""));
		setFri05(JSPUtil.getParameter(request, prefix + "fri05", ""));
		setFri06(JSPUtil.getParameter(request, prefix + "fri06", ""));
		setFri03(JSPUtil.getParameter(request, prefix + "fri03", ""));
		setFri04(JSPUtil.getParameter(request, prefix + "fri04", ""));
		setFri09(JSPUtil.getParameter(request, prefix + "fri09", ""));
		setFri07(JSPUtil.getParameter(request, prefix + "fri07", ""));
		setFri08(JSPUtil.getParameter(request, prefix + "fri08", ""));
		setThu16(JSPUtil.getParameter(request, prefix + "thu16", ""));
		setThu17(JSPUtil.getParameter(request, prefix + "thu17", ""));
		setWed03(JSPUtil.getParameter(request, prefix + "wed03", ""));
		setWed02(JSPUtil.getParameter(request, prefix + "wed02", ""));
		setThu14(JSPUtil.getParameter(request, prefix + "thu14", ""));
		setWed05(JSPUtil.getParameter(request, prefix + "wed05", ""));
		setThu15(JSPUtil.getParameter(request, prefix + "thu15", ""));
		setWed04(JSPUtil.getParameter(request, prefix + "wed04", ""));
		setWed07(JSPUtil.getParameter(request, prefix + "wed07", ""));
		setThu12(JSPUtil.getParameter(request, prefix + "thu12", ""));
		setWed06(JSPUtil.getParameter(request, prefix + "wed06", ""));
		setThu13(JSPUtil.getParameter(request, prefix + "thu13", ""));
		setWed09(JSPUtil.getParameter(request, prefix + "wed09", ""));
		setThu10(JSPUtil.getParameter(request, prefix + "thu10", ""));
		setWed08(JSPUtil.getParameter(request, prefix + "wed08", ""));
		setThu11(JSPUtil.getParameter(request, prefix + "thu11", ""));
		setWed01(JSPUtil.getParameter(request, prefix + "wed01", ""));
		setFri14(JSPUtil.getParameter(request, prefix + "fri14", ""));
		setFri15(JSPUtil.getParameter(request, prefix + "fri15", ""));
		setFri16(JSPUtil.getParameter(request, prefix + "fri16", ""));
		setFri17(JSPUtil.getParameter(request, prefix + "fri17", ""));
		setWed16(JSPUtil.getParameter(request, prefix + "wed16", ""));
		setWed17(JSPUtil.getParameter(request, prefix + "wed17", ""));
		setThu03(JSPUtil.getParameter(request, prefix + "thu03", ""));
		setWed15(JSPUtil.getParameter(request, prefix + "wed15", ""));
		setThu04(JSPUtil.getParameter(request, prefix + "thu04", ""));
		setWed14(JSPUtil.getParameter(request, prefix + "wed14", ""));
		setThu05(JSPUtil.getParameter(request, prefix + "thu05", ""));
		setWed13(JSPUtil.getParameter(request, prefix + "wed13", ""));
		setThu06(JSPUtil.getParameter(request, prefix + "thu06", ""));
		setThu01(JSPUtil.getParameter(request, prefix + "thu01", ""));
		setThu02(JSPUtil.getParameter(request, prefix + "thu02", ""));
		setWed12(JSPUtil.getParameter(request, prefix + "wed12", ""));
		setThu07(JSPUtil.getParameter(request, prefix + "thu07", ""));
		setWed11(JSPUtil.getParameter(request, prefix + "wed11", ""));
		setThu08(JSPUtil.getParameter(request, prefix + "thu08", ""));
		setWed10(JSPUtil.getParameter(request, prefix + "wed10", ""));
		setThu09(JSPUtil.getParameter(request, prefix + "thu09", ""));
		setSat06(JSPUtil.getParameter(request, prefix + "sat06", ""));
		setSat07(JSPUtil.getParameter(request, prefix + "sat07", ""));
		setSat08(JSPUtil.getParameter(request, prefix + "sat08", ""));
		setSat09(JSPUtil.getParameter(request, prefix + "sat09", ""));
		setSat02(JSPUtil.getParameter(request, prefix + "sat02", ""));
		setSat03(JSPUtil.getParameter(request, prefix + "sat03", ""));
		setSat04(JSPUtil.getParameter(request, prefix + "sat04", ""));
		setSat05(JSPUtil.getParameter(request, prefix + "sat05", ""));
		setSat01(JSPUtil.getParameter(request, prefix + "sat01", ""));
		setCount06(JSPUtil.getParameter(request, prefix + "count06", ""));
		setCount05(JSPUtil.getParameter(request, prefix + "count05", ""));
		setCount08(JSPUtil.getParameter(request, prefix + "count08", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCount07(JSPUtil.getParameter(request, prefix + "count07", ""));
		setCount02(JSPUtil.getParameter(request, prefix + "count02", ""));
		setCount01(JSPUtil.getParameter(request, prefix + "count01", ""));
		setCount04(JSPUtil.getParameter(request, prefix + "count04", ""));
		setCount03(JSPUtil.getParameter(request, prefix + "count03", ""));
		setCount09(JSPUtil.getParameter(request, prefix + "count09", ""));
		setCount10(JSPUtil.getParameter(request, prefix + "count10", ""));
		setCount11(JSPUtil.getParameter(request, prefix + "count11", ""));
		setCount16(JSPUtil.getParameter(request, prefix + "count16", ""));
		setCount17(JSPUtil.getParameter(request, prefix + "count17", ""));
		setCount15(JSPUtil.getParameter(request, prefix + "count15", ""));
		setCount14(JSPUtil.getParameter(request, prefix + "count14", ""));
		setCount13(JSPUtil.getParameter(request, prefix + "count13", ""));
		setCount12(JSPUtil.getParameter(request, prefix + "count12", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MTYCNTRPERFInDetailTrendVO[]
	 */
	public MTYCNTRPERFInDailyTrendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MTYCNTRPERFInDetailTrendVO[]
	 */
	public MTYCNTRPERFInDailyTrendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MTYCNTRPERFInDailyTrendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sun09 = (JSPUtil.getParameter(request, prefix	+ "sun09", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] sun08 = (JSPUtil.getParameter(request, prefix	+ "sun08", length));
			String[] sun05 = (JSPUtil.getParameter(request, prefix	+ "sun05", length));
			String[] sun04 = (JSPUtil.getParameter(request, prefix	+ "sun04", length));
			String[] sun07 = (JSPUtil.getParameter(request, prefix	+ "sun07", length));
			String[] sun06 = (JSPUtil.getParameter(request, prefix	+ "sun06", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sun01 = (JSPUtil.getParameter(request, prefix	+ "sun01", length));
			String[] sun02 = (JSPUtil.getParameter(request, prefix	+ "sun02", length));
			String[] sun03 = (JSPUtil.getParameter(request, prefix	+ "sun03", length));
			String[] wk = (JSPUtil.getParameter(request, prefix	+ "wk", length));
			String[] sun16 = (JSPUtil.getParameter(request, prefix	+ "sun16", length));
			String[] sun17 = (JSPUtil.getParameter(request, prefix	+ "sun17", length));
			String[] sun15 = (JSPUtil.getParameter(request, prefix	+ "sun15", length));
			String[] sun13 = (JSPUtil.getParameter(request, prefix	+ "sun13", length));
			String[] sun14 = (JSPUtil.getParameter(request, prefix	+ "sun14", length));
			String[] sun11 = (JSPUtil.getParameter(request, prefix	+ "sun11", length));
			String[] sun12 = (JSPUtil.getParameter(request, prefix	+ "sun12", length));
			String[] sun10 = (JSPUtil.getParameter(request, prefix	+ "sun10", length));
			String[] tue15 = (JSPUtil.getParameter(request, prefix	+ "tue15", length));
			String[] tue16 = (JSPUtil.getParameter(request, prefix	+ "tue16", length));
			String[] tue17 = (JSPUtil.getParameter(request, prefix	+ "tue17", length));
			String[] fri02 = (JSPUtil.getParameter(request, prefix	+ "fri02", length));
			String[] fri01 = (JSPUtil.getParameter(request, prefix	+ "fri01", length));
			String[] tue11 = (JSPUtil.getParameter(request, prefix	+ "tue11", length));
			String[] tue12 = (JSPUtil.getParameter(request, prefix	+ "tue12", length));
			String[] tue13 = (JSPUtil.getParameter(request, prefix	+ "tue13", length));
			String[] tue14 = (JSPUtil.getParameter(request, prefix	+ "tue14", length));
			String[] mon02 = (JSPUtil.getParameter(request, prefix	+ "mon02", length));
			String[] mon03 = (JSPUtil.getParameter(request, prefix	+ "mon03", length));
			String[] mon01 = (JSPUtil.getParameter(request, prefix	+ "mon01", length));
			String[] tue10 = (JSPUtil.getParameter(request, prefix	+ "tue10", length));
			String[] mon07 = (JSPUtil.getParameter(request, prefix	+ "mon07", length));
			String[] mon06 = (JSPUtil.getParameter(request, prefix	+ "mon06", length));
			String[] mon05 = (JSPUtil.getParameter(request, prefix	+ "mon05", length));
			String[] mon04 = (JSPUtil.getParameter(request, prefix	+ "mon04", length));
			String[] sat12 = (JSPUtil.getParameter(request, prefix	+ "sat12", length));
			String[] sat11 = (JSPUtil.getParameter(request, prefix	+ "sat11", length));
			String[] sat10 = (JSPUtil.getParameter(request, prefix	+ "sat10", length));
			String[] mon09 = (JSPUtil.getParameter(request, prefix	+ "mon09", length));
			String[] mon08 = (JSPUtil.getParameter(request, prefix	+ "mon08", length));
			String[] sat16 = (JSPUtil.getParameter(request, prefix	+ "sat16", length));
			String[] sat17 = (JSPUtil.getParameter(request, prefix	+ "sat17", length));
			String[] sat15 = (JSPUtil.getParameter(request, prefix	+ "sat15", length));
			String[] sat14 = (JSPUtil.getParameter(request, prefix	+ "sat14", length));
			String[] sat13 = (JSPUtil.getParameter(request, prefix	+ "sat13", length));
			String[] tue08 = (JSPUtil.getParameter(request, prefix	+ "tue08", length));
			String[] tue09 = (JSPUtil.getParameter(request, prefix	+ "tue09", length));
			String[] fri13 = (JSPUtil.getParameter(request, prefix	+ "fri13", length));
			String[] tue06 = (JSPUtil.getParameter(request, prefix	+ "tue06", length));
			String[] fri12 = (JSPUtil.getParameter(request, prefix	+ "fri12", length));
			String[] tue07 = (JSPUtil.getParameter(request, prefix	+ "tue07", length));
			String[] fri11 = (JSPUtil.getParameter(request, prefix	+ "fri11", length));
			String[] tue04 = (JSPUtil.getParameter(request, prefix	+ "tue04", length));
			String[] fri10 = (JSPUtil.getParameter(request, prefix	+ "fri10", length));
			String[] tue05 = (JSPUtil.getParameter(request, prefix	+ "tue05", length));
			String[] tue02 = (JSPUtil.getParameter(request, prefix	+ "tue02", length));
			String[] tue03 = (JSPUtil.getParameter(request, prefix	+ "tue03", length));
			String[] mon10 = (JSPUtil.getParameter(request, prefix	+ "mon10", length));
			String[] tue01 = (JSPUtil.getParameter(request, prefix	+ "tue01", length));
			String[] mon11 = (JSPUtil.getParameter(request, prefix	+ "mon11", length));
			String[] mon12 = (JSPUtil.getParameter(request, prefix	+ "mon12", length));
			String[] mon13 = (JSPUtil.getParameter(request, prefix	+ "mon13", length));
			String[] mon14 = (JSPUtil.getParameter(request, prefix	+ "mon14", length));
			String[] mon16 = (JSPUtil.getParameter(request, prefix	+ "mon16", length));
			String[] mon17 = (JSPUtil.getParameter(request, prefix	+ "mon17", length));
			String[] mon15 = (JSPUtil.getParameter(request, prefix	+ "mon15", length));
			String[] fri05 = (JSPUtil.getParameter(request, prefix	+ "fri05", length));
			String[] fri06 = (JSPUtil.getParameter(request, prefix	+ "fri06", length));
			String[] fri03 = (JSPUtil.getParameter(request, prefix	+ "fri03", length));
			String[] fri04 = (JSPUtil.getParameter(request, prefix	+ "fri04", length));
			String[] fri09 = (JSPUtil.getParameter(request, prefix	+ "fri09", length));
			String[] fri07 = (JSPUtil.getParameter(request, prefix	+ "fri07", length));
			String[] fri08 = (JSPUtil.getParameter(request, prefix	+ "fri08", length));
			String[] thu16 = (JSPUtil.getParameter(request, prefix	+ "thu16", length));
			String[] thu17 = (JSPUtil.getParameter(request, prefix	+ "thu17", length));
			String[] wed03 = (JSPUtil.getParameter(request, prefix	+ "wed03", length));
			String[] wed02 = (JSPUtil.getParameter(request, prefix	+ "wed02", length));
			String[] thu14 = (JSPUtil.getParameter(request, prefix	+ "thu14", length));
			String[] wed05 = (JSPUtil.getParameter(request, prefix	+ "wed05", length));
			String[] thu15 = (JSPUtil.getParameter(request, prefix	+ "thu15", length));
			String[] wed04 = (JSPUtil.getParameter(request, prefix	+ "wed04", length));
			String[] wed07 = (JSPUtil.getParameter(request, prefix	+ "wed07", length));
			String[] thu12 = (JSPUtil.getParameter(request, prefix	+ "thu12", length));
			String[] wed06 = (JSPUtil.getParameter(request, prefix	+ "wed06", length));
			String[] thu13 = (JSPUtil.getParameter(request, prefix	+ "thu13", length));
			String[] wed09 = (JSPUtil.getParameter(request, prefix	+ "wed09", length));
			String[] thu10 = (JSPUtil.getParameter(request, prefix	+ "thu10", length));
			String[] wed08 = (JSPUtil.getParameter(request, prefix	+ "wed08", length));
			String[] thu11 = (JSPUtil.getParameter(request, prefix	+ "thu11", length));
			String[] wed01 = (JSPUtil.getParameter(request, prefix	+ "wed01", length));
			String[] fri14 = (JSPUtil.getParameter(request, prefix	+ "fri14", length));
			String[] fri15 = (JSPUtil.getParameter(request, prefix	+ "fri15", length));
			String[] fri16 = (JSPUtil.getParameter(request, prefix	+ "fri16", length));
			String[] fri17 = (JSPUtil.getParameter(request, prefix	+ "fri17", length));
			String[] wed16 = (JSPUtil.getParameter(request, prefix	+ "wed16", length));
			String[] wed17 = (JSPUtil.getParameter(request, prefix	+ "wed17", length));
			String[] thu03 = (JSPUtil.getParameter(request, prefix	+ "thu03", length));
			String[] wed15 = (JSPUtil.getParameter(request, prefix	+ "wed15", length));
			String[] thu04 = (JSPUtil.getParameter(request, prefix	+ "thu04", length));
			String[] wed14 = (JSPUtil.getParameter(request, prefix	+ "wed14", length));
			String[] thu05 = (JSPUtil.getParameter(request, prefix	+ "thu05", length));
			String[] wed13 = (JSPUtil.getParameter(request, prefix	+ "wed13", length));
			String[] thu06 = (JSPUtil.getParameter(request, prefix	+ "thu06", length));
			String[] thu01 = (JSPUtil.getParameter(request, prefix	+ "thu01", length));
			String[] thu02 = (JSPUtil.getParameter(request, prefix	+ "thu02", length));
			String[] wed12 = (JSPUtil.getParameter(request, prefix	+ "wed12", length));
			String[] thu07 = (JSPUtil.getParameter(request, prefix	+ "thu07", length));
			String[] wed11 = (JSPUtil.getParameter(request, prefix	+ "wed11", length));
			String[] thu08 = (JSPUtil.getParameter(request, prefix	+ "thu08", length));
			String[] wed10 = (JSPUtil.getParameter(request, prefix	+ "wed10", length));
			String[] thu09 = (JSPUtil.getParameter(request, prefix	+ "thu09", length));
			String[] sat06 = (JSPUtil.getParameter(request, prefix	+ "sat06", length));
			String[] sat07 = (JSPUtil.getParameter(request, prefix	+ "sat07", length));
			String[] sat08 = (JSPUtil.getParameter(request, prefix	+ "sat08", length));
			String[] sat09 = (JSPUtil.getParameter(request, prefix	+ "sat09", length));
			String[] sat02 = (JSPUtil.getParameter(request, prefix	+ "sat02", length));
			String[] sat03 = (JSPUtil.getParameter(request, prefix	+ "sat03", length));
			String[] sat04 = (JSPUtil.getParameter(request, prefix	+ "sat04", length));
			String[] sat05 = (JSPUtil.getParameter(request, prefix	+ "sat05", length));
			String[] sat01 = (JSPUtil.getParameter(request, prefix	+ "sat01", length));
			String[] count06 = (JSPUtil.getParameter(request, prefix	+ "count06", length));
			String[] count05 = (JSPUtil.getParameter(request, prefix	+ "count05", length));
			String[] count08 = (JSPUtil.getParameter(request, prefix	+ "count08", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] count07 = (JSPUtil.getParameter(request, prefix	+ "count07", length));
			String[] count02 = (JSPUtil.getParameter(request, prefix	+ "count02", length));
			String[] count01 = (JSPUtil.getParameter(request, prefix	+ "count01", length));
			String[] count04 = (JSPUtil.getParameter(request, prefix	+ "count04", length));
			String[] count03 = (JSPUtil.getParameter(request, prefix	+ "count03", length));
			String[] count09 = (JSPUtil.getParameter(request, prefix	+ "count09", length));
			String[] count10 = (JSPUtil.getParameter(request, prefix	+ "count10", length));
			String[] count11 = (JSPUtil.getParameter(request, prefix	+ "count11", length));
			String[] count16 = (JSPUtil.getParameter(request, prefix	+ "count16", length));
			String[] count17 = (JSPUtil.getParameter(request, prefix	+ "count17", length));
			String[] count15 = (JSPUtil.getParameter(request, prefix	+ "count15", length));
			String[] count14 = (JSPUtil.getParameter(request, prefix	+ "count14", length));
			String[] count13 = (JSPUtil.getParameter(request, prefix	+ "count13", length));
			String[] count12 = (JSPUtil.getParameter(request, prefix	+ "count12", length));
			
			for (int i = 0; i < length; i++) {
				model = new MTYCNTRPERFInDailyTrendVO();
				if (sun09[i] != null)
					model.setSun09(sun09[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (sun08[i] != null)
					model.setSun08(sun08[i]);
				if (sun05[i] != null)
					model.setSun05(sun05[i]);
				if (sun04[i] != null)
					model.setSun04(sun04[i]);
				if (sun07[i] != null)
					model.setSun07(sun07[i]);
				if (sun06[i] != null)
					model.setSun06(sun06[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sun01[i] != null)
					model.setSun01(sun01[i]);
				if (sun02[i] != null)
					model.setSun02(sun02[i]);
				if (sun03[i] != null)
					model.setSun03(sun03[i]);
				if (wk[i] != null)
					model.setWk(wk[i]);
				if (sun16[i] != null)
					model.setSun16(sun16[i]);
				if (sun17[i] != null)
					model.setSun17(sun17[i]);
				if (sun15[i] != null)
					model.setSun15(sun15[i]);
				if (sun13[i] != null)
					model.setSun13(sun13[i]);
				if (sun14[i] != null)
					model.setSun14(sun14[i]);
				if (sun11[i] != null)
					model.setSun11(sun11[i]);
				if (sun12[i] != null)
					model.setSun12(sun12[i]);
				if (sun10[i] != null)
					model.setSun10(sun10[i]);
				if (tue15[i] != null)
					model.setTue15(tue15[i]);
				if (tue16[i] != null)
					model.setTue16(tue16[i]);
				if (tue17[i] != null)
					model.setTue17(tue17[i]);
				if (fri02[i] != null)
					model.setFri02(fri02[i]);
				if (fri01[i] != null)
					model.setFri01(fri01[i]);
				if (tue11[i] != null)
					model.setTue11(tue11[i]);
				if (tue12[i] != null)
					model.setTue12(tue12[i]);
				if (tue13[i] != null)
					model.setTue13(tue13[i]);
				if (tue14[i] != null)
					model.setTue14(tue14[i]);
				if (mon02[i] != null)
					model.setMon02(mon02[i]);
				if (mon03[i] != null)
					model.setMon03(mon03[i]);
				if (mon01[i] != null)
					model.setMon01(mon01[i]);
				if (tue10[i] != null)
					model.setTue10(tue10[i]);
				if (mon07[i] != null)
					model.setMon07(mon07[i]);
				if (mon06[i] != null)
					model.setMon06(mon06[i]);
				if (mon05[i] != null)
					model.setMon05(mon05[i]);
				if (mon04[i] != null)
					model.setMon04(mon04[i]);
				if (sat12[i] != null)
					model.setSat12(sat12[i]);
				if (sat11[i] != null)
					model.setSat11(sat11[i]);
				if (sat10[i] != null)
					model.setSat10(sat10[i]);
				if (mon09[i] != null)
					model.setMon09(mon09[i]);
				if (mon08[i] != null)
					model.setMon08(mon08[i]);
				if (sat16[i] != null)
					model.setSat16(sat16[i]);
				if (sat17[i] != null)
					model.setSat17(sat17[i]);
				if (sat15[i] != null)
					model.setSat15(sat15[i]);
				if (sat14[i] != null)
					model.setSat14(sat14[i]);
				if (sat13[i] != null)
					model.setSat13(sat13[i]);
				if (tue08[i] != null)
					model.setTue08(tue08[i]);
				if (tue09[i] != null)
					model.setTue09(tue09[i]);
				if (fri13[i] != null)
					model.setFri13(fri13[i]);
				if (tue06[i] != null)
					model.setTue06(tue06[i]);
				if (fri12[i] != null)
					model.setFri12(fri12[i]);
				if (tue07[i] != null)
					model.setTue07(tue07[i]);
				if (fri11[i] != null)
					model.setFri11(fri11[i]);
				if (tue04[i] != null)
					model.setTue04(tue04[i]);
				if (fri10[i] != null)
					model.setFri10(fri10[i]);
				if (tue05[i] != null)
					model.setTue05(tue05[i]);
				if (tue02[i] != null)
					model.setTue02(tue02[i]);
				if (tue03[i] != null)
					model.setTue03(tue03[i]);
				if (mon10[i] != null)
					model.setMon10(mon10[i]);
				if (tue01[i] != null)
					model.setTue01(tue01[i]);
				if (mon11[i] != null)
					model.setMon11(mon11[i]);
				if (mon12[i] != null)
					model.setMon12(mon12[i]);
				if (mon13[i] != null)
					model.setMon13(mon13[i]);
				if (mon14[i] != null)
					model.setMon14(mon14[i]);
				if (mon16[i] != null)
					model.setMon16(mon16[i]);
				if (mon17[i] != null)
					model.setMon17(mon17[i]);
				if (mon15[i] != null)
					model.setMon15(mon15[i]);
				if (fri05[i] != null)
					model.setFri05(fri05[i]);
				if (fri06[i] != null)
					model.setFri06(fri06[i]);
				if (fri03[i] != null)
					model.setFri03(fri03[i]);
				if (fri04[i] != null)
					model.setFri04(fri04[i]);
				if (fri09[i] != null)
					model.setFri09(fri09[i]);
				if (fri07[i] != null)
					model.setFri07(fri07[i]);
				if (fri08[i] != null)
					model.setFri08(fri08[i]);
				if (thu16[i] != null)
					model.setThu16(thu16[i]);
				if (thu17[i] != null)
					model.setThu17(thu17[i]);
				if (wed03[i] != null)
					model.setWed03(wed03[i]);
				if (wed02[i] != null)
					model.setWed02(wed02[i]);
				if (thu14[i] != null)
					model.setThu14(thu14[i]);
				if (wed05[i] != null)
					model.setWed05(wed05[i]);
				if (thu15[i] != null)
					model.setThu15(thu15[i]);
				if (wed04[i] != null)
					model.setWed04(wed04[i]);
				if (wed07[i] != null)
					model.setWed07(wed07[i]);
				if (thu12[i] != null)
					model.setThu12(thu12[i]);
				if (wed06[i] != null)
					model.setWed06(wed06[i]);
				if (thu13[i] != null)
					model.setThu13(thu13[i]);
				if (wed09[i] != null)
					model.setWed09(wed09[i]);
				if (thu10[i] != null)
					model.setThu10(thu10[i]);
				if (wed08[i] != null)
					model.setWed08(wed08[i]);
				if (thu11[i] != null)
					model.setThu11(thu11[i]);
				if (wed01[i] != null)
					model.setWed01(wed01[i]);
				if (fri14[i] != null)
					model.setFri14(fri14[i]);
				if (fri15[i] != null)
					model.setFri15(fri15[i]);
				if (fri16[i] != null)
					model.setFri16(fri16[i]);
				if (fri17[i] != null)
					model.setFri17(fri17[i]);
				if (wed16[i] != null)
					model.setWed16(wed16[i]);
				if (wed17[i] != null)
					model.setWed17(wed17[i]);
				if (thu03[i] != null)
					model.setThu03(thu03[i]);
				if (wed15[i] != null)
					model.setWed15(wed15[i]);
				if (thu04[i] != null)
					model.setThu04(thu04[i]);
				if (wed14[i] != null)
					model.setWed14(wed14[i]);
				if (thu05[i] != null)
					model.setThu05(thu05[i]);
				if (wed13[i] != null)
					model.setWed13(wed13[i]);
				if (thu06[i] != null)
					model.setThu06(thu06[i]);
				if (thu01[i] != null)
					model.setThu01(thu01[i]);
				if (thu02[i] != null)
					model.setThu02(thu02[i]);
				if (wed12[i] != null)
					model.setWed12(wed12[i]);
				if (thu07[i] != null)
					model.setThu07(thu07[i]);
				if (wed11[i] != null)
					model.setWed11(wed11[i]);
				if (thu08[i] != null)
					model.setThu08(thu08[i]);
				if (wed10[i] != null)
					model.setWed10(wed10[i]);
				if (thu09[i] != null)
					model.setThu09(thu09[i]);
				if (sat06[i] != null)
					model.setSat06(sat06[i]);
				if (sat07[i] != null)
					model.setSat07(sat07[i]);
				if (sat08[i] != null)
					model.setSat08(sat08[i]);
				if (sat09[i] != null)
					model.setSat09(sat09[i]);
				if (sat02[i] != null)
					model.setSat02(sat02[i]);
				if (sat03[i] != null)
					model.setSat03(sat03[i]);
				if (sat04[i] != null)
					model.setSat04(sat04[i]);
				if (sat05[i] != null)
					model.setSat05(sat05[i]);
				if (sat01[i] != null)
					model.setSat01(sat01[i]);
				if (count06[i] != null)
					model.setCount06(count06[i]);
				if (count05[i] != null)
					model.setCount05(count05[i]);
				if (count08[i] != null)
					model.setCount08(count08[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (count07[i] != null)
					model.setCount07(count07[i]);
				if (count02[i] != null)
					model.setCount02(count02[i]);
				if (count01[i] != null)
					model.setCount01(count01[i]);
				if (count04[i] != null)
					model.setCount04(count04[i]);
				if (count03[i] != null)
					model.setCount03(count03[i]);
				if (count09[i] != null)
					model.setCount09(count09[i]);
				if (count10[i] != null)
					model.setCount10(count10[i]);
				if (count11[i] != null)
					model.setCount11(count11[i]);
				if (count16[i] != null)
					model.setCount16(count16[i]);
				if (count17[i] != null)
					model.setCount17(count17[i]);
				if (count15[i] != null)
					model.setCount15(count15[i]);
				if (count14[i] != null)
					model.setCount14(count14[i]);
				if (count13[i] != null)
					model.setCount13(count13[i]);
				if (count12[i] != null)
					model.setCount12(count12[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMTYCNTRPERFInDetailTrendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MTYCNTRPERFInDetailTrendVO[]
	 */
	public MTYCNTRPERFInDailyTrendVO[] getMTYCNTRPERFInDetailTrendVOs(){
		MTYCNTRPERFInDailyTrendVO[] vos = (MTYCNTRPERFInDailyTrendVO[])models.toArray(new MTYCNTRPERFInDailyTrendVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.sun09 = this.sun09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun08 = this.sun08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun05 = this.sun05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun04 = this.sun04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun07 = this.sun07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun06 = this.sun06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun01 = this.sun01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun02 = this.sun02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun03 = this.sun03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk = this.wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun16 = this.sun16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun17 = this.sun17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun15 = this.sun15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun13 = this.sun13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun14 = this.sun14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun11 = this.sun11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun12 = this.sun12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sun10 = this.sun10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue15 = this.tue15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue16 = this.tue16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue17 = this.tue17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri02 = this.fri02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri01 = this.fri01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue11 = this.tue11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue12 = this.tue12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue13 = this.tue13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue14 = this.tue14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon02 = this.mon02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon03 = this.mon03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon01 = this.mon01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue10 = this.tue10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon07 = this.mon07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon06 = this.mon06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon05 = this.mon05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon04 = this.mon04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat12 = this.sat12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat11 = this.sat11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat10 = this.sat10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon09 = this.mon09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon08 = this.mon08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat16 = this.sat16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat17 = this.sat17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat15 = this.sat15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat14 = this.sat14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat13 = this.sat13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue08 = this.tue08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue09 = this.tue09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri13 = this.fri13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue06 = this.tue06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri12 = this.fri12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue07 = this.tue07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri11 = this.fri11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue04 = this.tue04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri10 = this.fri10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue05 = this.tue05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue02 = this.tue02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue03 = this.tue03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon10 = this.mon10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tue01 = this.tue01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon11 = this.mon11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon12 = this.mon12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon13 = this.mon13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon14 = this.mon14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon16 = this.mon16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon17 = this.mon17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon15 = this.mon15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri05 = this.fri05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri06 = this.fri06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri03 = this.fri03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri04 = this.fri04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri09 = this.fri09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri07 = this.fri07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri08 = this.fri08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu16 = this.thu16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu17 = this.thu17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed03 = this.wed03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed02 = this.wed02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu14 = this.thu14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed05 = this.wed05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu15 = this.thu15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed04 = this.wed04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed07 = this.wed07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu12 = this.thu12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed06 = this.wed06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu13 = this.thu13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed09 = this.wed09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu10 = this.thu10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed08 = this.wed08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu11 = this.thu11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed01 = this.wed01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri14 = this.fri14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri15 = this.fri15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri16 = this.fri16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fri17 = this.fri17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed16 = this.wed16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed17 = this.wed17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu03 = this.thu03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed15 = this.wed15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu04 = this.thu04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed14 = this.wed14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu05 = this.thu05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed13 = this.wed13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu06 = this.thu06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu01 = this.thu01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu02 = this.thu02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed12 = this.wed12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu07 = this.thu07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed11 = this.wed11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu08 = this.thu08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wed10 = this.wed10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thu09 = this.thu09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat06 = this.sat06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat07 = this.sat07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat08 = this.sat08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat09 = this.sat09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat02 = this.sat02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat03 = this.sat03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat04 = this.sat04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat05 = this.sat05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sat01 = this.sat01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count06 = this.count06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count05 = this.count05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count08 = this.count08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count07 = this.count07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count02 = this.count02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count01 = this.count01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count04 = this.count04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count03 = this.count03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count09 = this.count09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count10 = this.count10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count11 = this.count11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count16 = this.count16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count17 = this.count17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count15 = this.count15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count14 = this.count14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count13 = this.count13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count12 = this.count12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
