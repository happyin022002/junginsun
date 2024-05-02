/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchAutoBLListReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.22 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchAutoBLListReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2.Non Autorating B/L List
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchAutoBLListReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchAutoBLListReportRSQL").append("\n"); 
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
		query.append("SELECT    DENSE_RANK() OVER(PARTITION BY T.AA ORDER BY T.BKG_NO)  ROW_NUM" ).append("\n"); 
		query.append(",		T.BKG_NO" ).append("\n"); 
		query.append(",       T.RT_SEQ" ).append("\n"); 
		query.append(",       T.SVC_SCP_CD" ).append("\n"); 
		query.append(",       T.SC_NO" ).append("\n"); 
		query.append(",       T.BKG_OFC_CD" ).append("\n"); 
		query.append(",       T.REGION" ).append("\n"); 
		query.append(",       T.CMDT_CD" ).append("\n"); 
		query.append(",       T.CMDT_NM" ).append("\n"); 
		query.append(",       T.RATER" ).append("\n"); 
		query.append(",       T.RATER_OFC" ).append("\n"); 
		query.append(",       T.CHG_CD" ).append("\n"); 
		query.append(",       T.RAT_UT_CD" ).append("\n"); 
		query.append(",		T.AUTO_RAT_CD" ).append("\n"); 
		query.append(",       T.AUTO_RAT_FLG" ).append("\n"); 
		query.append(",       T.AUTO_DEL_FLG" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT '1' AA" ).append("\n"); 
		query.append(",		BK.BKG_NO" ).append("\n"); 
		query.append(",      RT.RT_SEQ" ).append("\n"); 
		query.append(",      BK.SVC_SCP_CD" ).append("\n"); 
		query.append(",      BK.SC_NO" ).append("\n"); 
		query.append(",      BK.BKG_OFC_CD" ).append("\n"); 
		query.append(",      OL.REGION" ).append("\n"); 
		query.append(",      BK.CMDT_CD" ).append("\n"); 
		query.append(",      (SELECT BL.CSTMS_DESC FROM BKG_BL_DOC BL WHERE BL.BKG_NO = BK.BKG_NO) CMDT_NM" ).append("\n"); 
		query.append(",      RT.CRE_USR_ID RATER" ).append("\n"); 
		query.append(",      (SELECT CU.OFC_CD FROM COM_USER CU WHERE CU.USR_ID = RT.CRE_USR_ID) RATER_OFC" ).append("\n"); 
		query.append(",       RT.CHG_CD" ).append("\n"); 
		query.append(",       RT.RAT_UT_CD" ).append("\n"); 
		query.append(",       RT.AUTO_RAT_CD" ).append("\n"); 
		query.append(",       MC.AUTO_RAT_FLG" ).append("\n"); 
		query.append(",       'N' AUTO_DEL_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING     BK" ).append("\n"); 
		query.append(",      BKG_OFC_LVL_V   OL" ).append("\n"); 
		query.append(",      BKG_CHG_RT      RT" ).append("\n"); 
		query.append(",      MDM_CHARGE      MC" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#if (${fr_dt} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_CRE_DT >= TO_DATE(@[fr_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_CRE_DT <  TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    OL.OFC_CD   = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("AND    BK.BKG_NO   = RT.BKG_NO" ).append("\n"); 
		query.append("AND    RT.CHG_CD = MC.CHG_CD" ).append("\n"); 
		query.append("AND    MC.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${sel_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   BK.BKG_OFC_CD = @[sel_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_scp_cd} != '')" ).append("\n"); 
		query.append("AND   BK.SVC_SCP_CD = @[sel_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND	   RT.CHG_CD =  @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '1' AA" ).append("\n"); 
		query.append(",		BK.BKG_NO" ).append("\n"); 
		query.append(",      HIS.RT_SEQ" ).append("\n"); 
		query.append(",      BK.SVC_SCP_CD" ).append("\n"); 
		query.append(",      BK.SC_NO" ).append("\n"); 
		query.append(",      BK.BKG_OFC_CD" ).append("\n"); 
		query.append(",      OL.REGION" ).append("\n"); 
		query.append(",      BK.CMDT_CD" ).append("\n"); 
		query.append(",      (SELECT BL.CSTMS_DESC FROM BKG_BL_DOC BL WHERE BL.BKG_NO = BK.BKG_NO) CMDT_NM" ).append("\n"); 
		query.append(",      HIS.CRE_USR_ID RATER" ).append("\n"); 
		query.append(",      (SELECT CU.OFC_CD FROM COM_USER CU WHERE CU.USR_ID = HIS.CRE_USR_ID) RATER_OFC" ).append("\n"); 
		query.append(",       HIS.CHG_CD" ).append("\n"); 
		query.append(",       HIS.RAT_UT_CD" ).append("\n"); 
		query.append(",       HIS.AUTO_RAT_CD" ).append("\n"); 
		query.append(",       MC.AUTO_RAT_FLG" ).append("\n"); 
		query.append(",       'Y' AUTO_DEL_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING     BK" ).append("\n"); 
		query.append(",      BKG_CHG_RT      RT" ).append("\n"); 
		query.append(",      BKG_OFC_LVL_V   OL" ).append("\n"); 
		query.append(",      MDM_CHARGE      MC" ).append("\n"); 
		query.append(",      BKG_AUTO_RT_HIS HIS" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#if (${fr_dt} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_CRE_DT >= TO_DATE(@[fr_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_CRE_DT <  TO_DATE(@[to_dt], 'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    OL.OFC_CD   = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("AND    RT.BKG_NO   = BK.BKG_NO" ).append("\n"); 
		query.append("AND    BK.BKG_NO   = HIS.BKG_NO" ).append("\n"); 
		query.append("AND    HIS.CHG_CD = MC.CHG_CD" ).append("\n"); 
		query.append("AND    MC.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${sel_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   BK.BKG_OFC_CD = @[sel_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_scp_cd} != '')" ).append("\n"); 
		query.append("AND   BK.SVC_SCP_CD = @[sel_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND	   HIS.CHG_CD =  @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 1 FROM BKG_CHG_RT RT WHERE RT.BKG_NO = HIS.BKG_NO AND RT.RT_SEQ = HIS.RT_SEQ)" ).append("\n"); 
		query.append(")  T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auto_rat_flg} == 'Y')" ).append("\n"); 
		query.append("AND	  (T.AUTO_DEL_FLG = 'N' AND T.AUTO_RAT_CD = 'A')" ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 1 FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("WHERE RT.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("AND   RT.AUTO_RAT_CD <> 'A'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM   MDM_CHARGE      MC" ).append("\n"); 
		query.append(",      BKG_AUTO_RT_HIS HIS" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    HIS.CHG_CD = MC.CHG_CD" ).append("\n"); 
		query.append("AND    MC.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND    HIS.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("AND    NOT EXISTS (SELECT 1 FROM BKG_CHG_RT RT WHERE RT.BKG_NO = HIS.BKG_NO AND RT.RT_SEQ = HIS.RT_SEQ)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${auto_rat_flg} == 'N')" ).append("\n"); 
		query.append("AND   (T.AUTO_DEL_FLG = 'Y' OR  T.AUTO_RAT_CD <> 'A') AND T.AUTO_RAT_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY    T.BKG_NO,T.RT_SEQ" ).append("\n"); 

	}
}