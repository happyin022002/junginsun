/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
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

public class InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss 에서 ApPayInvDtl 을 구한다.
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL(){
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
		query.append("FileName : InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL").append("\n"); 
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
		query.append("		'' INV_RGST_SEQ," ).append("\n"); 
		query.append("		'' LGS_COST_CD," ).append("\n"); 
		query.append("		DECODE(PW.TTL_LSS_DIV_CD, 'BBCOST', '510892', '510891') ACCT_CD," ).append("\n"); 
		query.append("		NVL(TD.VSL_CD, 'CNTC') VSL_CD," ).append("\n"); 
		query.append("		NVL(TD.SKD_VOY_NO, TO_CHAR(TH.TTL_LSS_CFM_DT, 'YYMM')) SKD_VOY_NO," ).append("\n"); 
		query.append("		NVL(TD.SKD_DIR_CD, 'M') SKD_DIR_CD," ).append("\n"); 
		query.append("		NVL(TD.REV_DIR_CD, 'M') REV_DIR_CD," ).append("\n"); 
		query.append("		NVL(TD.SLAN_CD, 'CNT') SLAN_CD," ).append("\n"); 
		query.append("		'' ACT_VVD_CD," ).append("\n"); 
		query.append("		'' PORT_CD," ).append("\n"); 
		query.append("		'' YD_CD," ).append("\n"); 
		query.append("		TD.EQ_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		SUM(TD.TTL_LSS_BIL_AMT) INV_AMT," ).append("\n"); 
		query.append("		0 SO_20FT_QTY," ).append("\n"); 
		query.append("		0 SO_40FT_QTY," ).append("\n"); 
		query.append("		0 SO_TEU_QTY," ).append("\n"); 
		query.append("		0 SO_UT_QTY," ).append("\n"); 
		query.append("		'' SO_OFC_CTY_CD," ).append("\n"); 
		query.append("		0 SO_SEQ," ).append("\n"); 
		query.append("		'N' DELT_FLG," ).append("\n"); 
		query.append("		CASE WHEN AI.ACT_DT_NM = 'TOTAL LOSS DATE' THEN TO_CHAR(TH.TTL_LSS_DT, 'YYYYMMDD') ELSE '' END ACT_DT," ).append("\n"); 
		query.append("		CASE WHEN AI.ACT_PLC_NM = 'ISSUE TEAM' THEN PW.ISS_OFC_CD ELSE '' END ACT_PLC" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL TD, MNR_TTL_LSS_RQST_HDR TH, MNR_PAY_INV_WRK PW, SCO_AP_COST_ACT_INFO AI" ).append("\n"); 
		query.append("WHERE TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("AND   TD.PAY_INV_SEQ     = PW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   PW.TTL_LSS_DIV_CD  = AI.ACT_COST_CD" ).append("\n"); 
		query.append("AND   AI.SRC_MDL_CD      = 'MNR'" ).append("\n"); 
		query.append("AND   PW.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("GROUP BY DECODE(PW.TTL_LSS_DIV_CD, 'BBCOST', '510892', '510891'), " ).append("\n"); 
		query.append("    TD.EQ_TPSZ_CD, TH.TTL_LSS_CFM_DT, TH.TTL_LSS_DT, PW.ISS_OFC_CD, AI.ACT_DT_NM, AI.ACT_PLC_NM," ).append("\n"); 
		query.append("    TD.VSL_CD, TD.SKD_VOY_NO, TD.SKD_DIR_CD, TD.REV_DIR_CD, TD.SLAN_CD" ).append("\n"); 

	}
}