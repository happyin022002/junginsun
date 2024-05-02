/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOAutoratingScAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2015.07.24 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAutoratingScAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AutoratingScAvailable
	  * </pre>
	  */
	public BookingUtilDBDAOAutoratingScAvailableRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAutoratingScAvailableRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT COALESCE(" ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD||BKG_CTRL_PTY_CUST_SEQ IN (" ).append("\n"); 
		query.append("                                SELECT PTY.CUST_CNT_CD||PTY.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT AF.CUST_CNT_CD||AF.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_AFIL AF" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT /* 화면에 Application Date */" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = AF.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = AF.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND AF.SRC_INFO_CD <> 'AD' /*  AFFILIATE 에서 삭제 코드임 */" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' ' )," ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_CUST_HIS" ).append("\n"); 
		query.append("    WHERE BKG_NO =@[bkg_no]   /* 화면에 BKG NO*/" ).append("\n"); 
		query.append("	AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("    AND BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("    AND CUST_CNT_CD||CUST_SEQ IN(" ).append("\n"); 
		query.append("                                SELECT PTY.CUST_CNT_CD||PTY.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT AF.CUST_CNT_CD||AF.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_AFIL AF" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT /* 화면에 Application Date */" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = AF.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = AF.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND AF.SRC_INFO_CD <> 'AD' /*  AFFILIATE 에서 삭제 코드임 */" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("								AND ROWNUM = 1" ).append("\n"); 
		query.append("								),'N') OUTPUT_TEXT" ).append("\n"); 
		query.append("                                FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT COALESCE(" ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_BOOKING" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD||BKG_CTRL_PTY_CUST_SEQ IN (" ).append("\n"); 
		query.append("                                SELECT PTY.CUST_CNT_CD||PTY.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT AF.CUST_CNT_CD||AF.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_AFIL AF" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT /* 화면에 Application Date */" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = AF.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = AF.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND AF.SRC_INFO_CD <> 'AD' /*  AFFILIATE 에서 삭제 코드임 */" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' ' )," ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("    WHERE BKG_NO =@[bkg_no]   /* 화면에 BKG NO*/" ).append("\n"); 
		query.append("    AND BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("    AND CUST_CNT_CD||CUST_SEQ IN(" ).append("\n"); 
		query.append("                                SELECT PTY.CUST_CNT_CD||PTY.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT AF.CUST_CNT_CD||AF.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_AFIL AF" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND HD.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("                                AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                --AND MN.PROP_STS_CD ='F' /* S/C 계약의 경우 STATUS 가 F인것만 사용 */" ).append("\n"); 
		query.append("                                AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT /* 화면에 Application Date */" ).append("\n"); 
		query.append("                                AND MN.PROP_NO = AF.PROP_NO" ).append("\n"); 
		query.append("                                AND MN.AMDT_SEQ = AF.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND AF.SRC_INFO_CD <> 'AD' /*  AFFILIATE 에서 삭제 코드임 */" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("								AND ROWNUM = 1" ).append("\n"); 
		query.append("								),'N') OUTPUT_TEXT" ).append("\n"); 
		query.append("                                FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}