/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchActualCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.22 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchActualCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchActualCustomerRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchActualCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("app_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchActualCustomerRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD,CUST_SEQ,CODE,CUST_LGL_ENG_NM,FROM_DT,TO_DT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  AC.CUST_CNT_CD || AC.CUST_SEQ AS CODE     ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')            AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')            AS TO_DT    ," ).append("\n"); 
		query.append("                AC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                AC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = AC.CUST_CNT_CD AND A.CUST_SEQ = AC.CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR    HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN     MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN SM  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("				BKG_BKG_HIS   BK" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				BKG_BOOKING   BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  NC.BKG_ACT_CUST_CNT_CD || NC.BKG_ACT_CUST_SEQ AS CODE ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')  AS FROM_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(SM.EXP_DT, 'YYYY-MM-DD')  AS TO_DT    ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_CNT_CD            AS CUST_CNT_CD  ," ).append("\n"); 
		query.append("                NC.BKG_ACT_CUST_SEQ               AS CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NC.BKG_ACT_CUST_CNT_CD AND A.CUST_SEQ = NC.BKG_ACT_CUST_SEQ )  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR        HD  ," ).append("\n"); 
		query.append("                PRI_SP_MN         MN  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN     SM  ," ).append("\n"); 
		query.append("                PRI_SC_NOTE_CONV  NC  ," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("				BKG_BKG_HIS   BK" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				BKG_BOOKING   BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.SC_NO        = @[sc_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='F'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${sc_no} == '') " ).append("\n"); 
		query.append("AND 'Y' = 'N'/*SWITCH*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("				BKG_BKG_HIS   BK" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				BKG_BOOKING   BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     AC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     AC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     AC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("				BKG_BKG_HIS   BK" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				BKG_BOOKING   BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     HD.RFA_NO        = @[rfa_no]" ).append("\n"); 
		query.append("        AND     MN.PROP_NO      = HD.PROP_NO" ).append("\n"); 
		query.append("        AND     MN.PROP_STS_CD  ='A'        /*상수*/" ).append("\n"); 
		query.append("        AND     SM.PROP_NO      = MN.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.AMDT_SEQ     = MN.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.SVC_SCP_CD   = SM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     TO_DATE(@[app_dt], 'YYYY-MM-DD') BETWEEN NC.EFF_DT AND NC.EXP_DT" ).append("\n"); 
		query.append("        AND     NC.BKG_ACT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("/*CUSTOMER Name*/" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_lgl_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_no} == '') " ).append("\n"); 
		query.append("AND 'Y' = 'N'/*SWITCH*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}