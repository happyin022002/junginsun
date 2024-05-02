/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCheckActualCustomerListExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCheckActualCustomerListExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer 를 고를 수 있는 List 가 존재하는 지 check 한다. (ESM_BKG_0079_05)
	  * GeneralBookingSearchDBDAOSearchActualCustomerRSQL 참고
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCheckActualCustomerListExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCheckActualCustomerListExistRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD,CUST_SEQ,CODE,CUST_LGL_ENG_NM,FROM_DT,TO_DT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  AC.CUST_CNT_CD || AC.CUST_SEQ AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                BKG_BOOKING   BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/ " ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BK.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ROWNUM = 1" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  NC.BKG_ACT_CUST_CNT_CD || NC.BKG_ACT_CUST_SEQ AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                RANK() OVER (PARTITION BY SM.SVC_SCP_CD ORDER BY DECODE(BK.SVC_SCP_CD, SM.SVC_SCP_CD, 1, 2)) AS RN" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   IN ( BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE', 'TPE', 'MXE', 'TPE') )" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BK.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE RN = 1  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD,CUST_SEQ,CODE,CUST_LGL_ENG_NM,FROM_DT,TO_DT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  AC.CUST_CNT_CD || AC.CUST_SEQ AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                BKG_BOOKING   BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = BK.RFA_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BK.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ROWNUM = 1" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  NC.BKG_ACT_CUST_CNT_CD || NC.BKG_ACT_CUST_SEQ AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_RP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = BK.RFA_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        --AND     TO_DATE(골[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BK.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND     ROWNUM = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}