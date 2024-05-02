/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.08.12 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
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
		query.append("'' INV_RGST_SEQ," ).append("\n"); 
		query.append("OD.COST_CD LGS_COST_CD," ).append("\n"); 
		query.append("OD.ACCT_CD ACCT_CD," ).append("\n"); 
		query.append("'CNTC' VSL_CD," ).append("\n"); 
		query.append("TO_CHAR(OD.CRE_DT, 'YYMM') SKD_VOY_NO," ).append("\n"); 
		query.append("'M' SKD_DIR_CD," ).append("\n"); 
		query.append("'M' REV_DIR_CD," ).append("\n"); 
		query.append("'CNT' SLAN_CD," ).append("\n"); 
		query.append("'' ACT_VVD_CD," ).append("\n"); 
		query.append("'' PORT_CD," ).append("\n"); 
		query.append("'' YD_CD," ).append("\n"); 
		query.append("OD.EQ_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,SUM(NVL(OD.INV_AMT,0))) INV_AMT," ).append("\n"); 
		query.append("0 SO_20FT_QTY," ).append("\n"); 
		query.append("0 SO_40FT_QTY," ).append("\n"); 
		query.append("0 SO_TEU_QTY," ).append("\n"); 
		query.append("0 SO_UT_QTY," ).append("\n"); 
		query.append("'' SO_OFC_CTY_CD," ).append("\n"); 
		query.append("0 SO_SEQ," ).append("\n"); 
		query.append("'N' DELT_FLG" ).append("\n"); 
		query.append("FROM   MNR_ORD_DTL OD, MNR_PAY_INV_WRK IW" ).append("\n"); 
		query.append("WHERE  IW.PAY_INV_SEQ = OD.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND IW.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("GROUP BY OD.COST_CD, OD.ACCT_CD, OD.EQ_TPSZ_CD, IW.CURR_CD, OD.CRE_DT" ).append("\n"); 

	}
}