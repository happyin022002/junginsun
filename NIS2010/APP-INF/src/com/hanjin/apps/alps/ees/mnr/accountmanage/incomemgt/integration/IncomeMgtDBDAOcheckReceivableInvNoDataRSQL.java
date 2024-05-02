/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IncomeMgtDBDAOcheckReceivableInvNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.05 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOcheckReceivableInvNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOcheckReceivableInvNoDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOcheckReceivableInvNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOcheckReceivableInvNoDataRSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK A" ).append("\n"); 
		query.append("	, MNR_DISP_DTL B" ).append("\n"); 
		query.append("WHERE A.RCV_INV_SEQ = B.RCV_INV_SEQ" ).append("\n"); 
		query.append("	AND A.MNR_INV_STS_CD = @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append("	AND B.INV_NO = @[input_inv_no]" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 

	}
}