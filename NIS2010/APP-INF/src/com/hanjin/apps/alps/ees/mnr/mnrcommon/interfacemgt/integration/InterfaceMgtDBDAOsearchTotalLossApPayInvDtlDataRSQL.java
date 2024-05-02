/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.13 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
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
		query.append("		DECODE(PW.TTL_LSS_DIV_CD, 'PO', '113331', 'GO', '510891', 'PL', '113331', 'GL', '510891') ACCT_CD," ).append("\n"); 
		query.append("		'CNTC' VSL_CD," ).append("\n"); 
		query.append("		TO_CHAR(TH.TTL_LSS_DT, 'YYMM') SKD_VOY_NO," ).append("\n"); 
		query.append("		'M' SKD_DIR_CD," ).append("\n"); 
		query.append("		'M' REV_DIR_CD," ).append("\n"); 
		query.append("		'CNT' SLAN_CD," ).append("\n"); 
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
		query.append("		'N' DELT_FLG " ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL TD, MNR_TTL_LSS_RQST_HDR TH, MNR_PAY_INV_WRK PW" ).append("\n"); 
		query.append("WHERE TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("AND   TD.PAY_INV_SEQ     = PW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   PW.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("GROUP BY DECODE(PW.TTL_LSS_DIV_CD, 'PO', '113331', 'GO', '510891', 'PL', '113331', 'GL', '510891'), " ).append("\n"); 
		query.append("    TD.EQ_TPSZ_CD, TH.TTL_LSS_DT" ).append("\n"); 

	}
}