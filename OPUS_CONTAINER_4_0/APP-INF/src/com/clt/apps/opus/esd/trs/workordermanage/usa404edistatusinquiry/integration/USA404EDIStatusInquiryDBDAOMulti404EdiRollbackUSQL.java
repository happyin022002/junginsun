/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.18 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 404 Edi 예외상황 발생시 EDI 상태 정보를 테이블에 UPDATE
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration ").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_EDI_RAIL_ORD" ).append("\n"); 
		query.append("SET BIL_EDI_RCV_RSLT_CD  = 'N'," ).append("\n"); 
		query.append("BIL_EDI_RCV_RSLT_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrlOfcCd])" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ    = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND   BIL_ISS_KNT    =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(BIL_ISS_KNT), 0) FROM TRS_TRSP_EDI_RAIL_ORD" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}