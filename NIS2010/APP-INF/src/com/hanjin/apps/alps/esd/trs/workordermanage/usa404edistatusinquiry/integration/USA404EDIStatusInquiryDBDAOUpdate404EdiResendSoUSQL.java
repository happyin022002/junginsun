/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.01.18 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * So 상태인 Resend EDI 정보 Update
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL(){
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
		params.put("ctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_EDI_RAIL_ORD_RSND X" ).append("\n"); 
		query.append("SET X.BIL_EDI_RSND_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrlOfcCd])" ).append("\n"); 
		query.append(", X.BIL_EDI_RSND_RCV_RSLT_CD = NULL" ).append("\n"); 
		query.append(",	X.BIL_EDI_RSND_RCV_RSLT_DT = NULL" ).append("\n"); 
		query.append(",	X.BIL_EDI_CTRL_SEQ = TRS_USA_RAIL_EDI_SEQ.NEXTVAL" ).append("\n"); 
		query.append("WHERE X.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND X.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}