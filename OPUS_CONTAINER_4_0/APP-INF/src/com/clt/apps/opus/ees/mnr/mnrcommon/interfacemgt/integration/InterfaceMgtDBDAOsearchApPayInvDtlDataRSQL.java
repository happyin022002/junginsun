/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL").append("\n"); 
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
		query.append("SELECT  '' INV_RGST_NO," ).append("\n"); 
		query.append("        '' INV_RGST_SEQ," ).append("\n"); 
		query.append("        OD.COST_CD LGS_COST_CD," ).append("\n"); 
		query.append("        OD.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("        NVL(OD.VSL_CD, 'CNTC') VSL_CD," ).append("\n"); 
		query.append("        NVL(OD.SKD_VOY_NO, TO_CHAR(IW.ISS_DT, 'YYMM')) SKD_VOY_NO," ).append("\n"); 
		query.append("        NVL(OD.SKD_DIR_CD, 'M') SKD_DIR_CD," ).append("\n"); 
		query.append("        NVL(OD.REV_DIR_CD, 'M') REV_DIR_CD," ).append("\n"); 
		query.append("        NVL(OD.SLAN_CD, 'CNT') SLAN_CD," ).append("\n"); 
		query.append("        '' ACT_VVD_CD," ).append("\n"); 
		query.append("        '' PORT_CD," ).append("\n"); 
		query.append("        '' YD_CD," ).append("\n"); 
		query.append("        OD.EQ_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,SUM(NVL(OD.INV_AMT,0))) INV_AMT," ).append("\n"); 
		query.append("        0 SO_20FT_QTY," ).append("\n"); 
		query.append("        0 SO_40FT_QTY," ).append("\n"); 
		query.append("        0 SO_TEU_QTY," ).append("\n"); 
		query.append("        0 SO_UT_QTY," ).append("\n"); 
		query.append("        '' SO_OFC_CTY_CD," ).append("\n"); 
		query.append("        0 SO_SEQ," ).append("\n"); 
		query.append("        'N' DELT_FLG," ).append("\n"); 
		query.append("        CASE WHEN AI.ACT_DT_NM = 'WO CREATION DATE' THEN TO_CHAR(OH.CRE_DT,'YYYYMMDD') ELSE '' END AS ACT_DT," ).append("\n"); 
		query.append("        CASE WHEN AI.ACT_PLC_NM = 'OFFICE' THEN OH.COST_OFC_CD ELSE '' END AS ACT_PLC " ).append("\n"); 
		query.append("FROM    MNR_ORD_HDR OH ,MNR_ORD_DTL OD, MNR_PAY_INV_WRK IW, SCO_AP_COST_ACT_INFO AI" ).append("\n"); 
		query.append("WHERE   OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND    OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append(" AND    OD.PAY_INV_SEQ = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append(" AND    OD.COST_CD     = AI.ACT_COST_CD" ).append("\n"); 
		query.append(" AND    OD.ACCT_CD     = AI.CONV_ACCT_CD" ).append("\n"); 
		query.append(" AND    AI.SRC_MDL_CD  = 'MNR'" ).append("\n"); 
		query.append(" AND IW.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("GROUP BY OH.MNR_WO_TP_CD,OD.YD_CD,IW.ISS_OFC_CD, OD.RPR_RSLT_DT,IW.INV_CFM_DT,OD.COST_CD, OD.ACCT_CD, OD.EQ_TPSZ_CD, IW.CURR_CD,IW.ISS_DT,OH.CRE_DT, OH.COST_OFC_CD, AI.ACT_DT_NM, AI.ACT_PLC_NM" ).append("\n"); 
		query.append("         ,OD.VSL_CD, OD.SKD_VOY_NO, OD.SKD_DIR_CD, OD.REV_DIR_CD, OD.SLAN_CD" ).append("\n"); 

	}
}