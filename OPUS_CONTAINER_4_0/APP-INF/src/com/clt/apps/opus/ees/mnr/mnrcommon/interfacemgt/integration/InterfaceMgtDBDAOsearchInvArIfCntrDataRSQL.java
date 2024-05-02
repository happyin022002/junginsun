/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.03.26 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), SYSDATE, @[user_ofc_cd]), 'yyyymmdd') AS UPD_DT," ).append("\n"); 
		query.append("		'' AS SRC_IF_SEQ," ).append("\n"); 
		query.append("		MRW.CRE_USR_ID," ).append("\n"); 
		query.append("		MDD.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("		MDD.EQ_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		'' AS CNTR_SEQ," ).append("\n"); 
		query.append("		TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), SYSDATE, @[user_ofc_cd]), 'yyyymmdd') AS CRE_DT," ).append("\n"); 
		query.append("		'' AS SRC_IF_DT," ).append("\n"); 
		query.append("		MRW.UPD_USR_ID" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK MRW, MNR_DISP_DTL MDD" ).append("\n"); 
		query.append("WHERE   MRW.RCV_INV_SEQ = MDD.RCV_INV_SEQ" ).append("\n"); 
		query.append(" AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 

	}
}