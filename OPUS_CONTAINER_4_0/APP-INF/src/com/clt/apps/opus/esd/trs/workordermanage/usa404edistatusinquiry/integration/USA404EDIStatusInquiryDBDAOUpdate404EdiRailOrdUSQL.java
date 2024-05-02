/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 상태를 SO 마스터 테이블에 수정 SQL
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("   SET SO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("      ,SO.WO_ISS_DT      = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrlOfcCd])" ).append("\n"); 
		query.append("      ,SO.BIL_ISS_KNT   =" ).append("\n"); 
		query.append("       (SELECT NVL(MAX(X.BIL_ISS_KNT), 0)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_EDI_RAIL_ORD X" ).append("\n"); 
		query.append("         WHERE X.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND X.TRSP_SO_SEQ = SO.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("      ,SO.BIL_ISS_STS_CD = 'I'" ).append("\n"); 
		query.append("      ,SO.UPD_USR_ID     = @[userId]" ).append("\n"); 
		query.append("      ,SO.LOCL_UPD_DT    = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrlOfcCd])" ).append("\n"); 
		query.append("      ,SO.WO_EXE_DT      = NVL(NVL(SO.ORG_GATE_OUT_DT, SO.DEST_GATE_IN_DT), WO_EXE_DT)" ).append("\n"); 
		query.append(" WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}