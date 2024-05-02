/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 전송을 위한 수하주 정보를 조회 한다.(보세운송동의서 승인 시)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_pty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoPtyTrspFlatFile01RSQL").append("\n"); 
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
		query.append("SELECT 'EP_TP:'     || EDO_PTY_CD         ||'\\n' -- 보세운송업체의 업종 Code AS : 실화주 PR : 세금계산서 공급받는 자 GA : 운송사 HD : Line 운송사 CN : 수하인  NI : 통지처  MS : 신청업체" ).append("\n"); 
		query.append("|| 'EP_REG_CD:' || A.PTY_RGST_NO      ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 Party(업체정보)의 사업자 등록번호" ).append("\n"); 
		query.append("|| 'EP_C_NM:'   || A.PTY_CNTC_PSON_NM ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 담당자 명" ).append("\n"); 
		query.append("|| 'EP_REP_NM:' || A.PTY_REP_NM       ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 대표자명" ).append("\n"); 
		query.append("|| 'EP_TEL_NO:' || A.PHN_NO           ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 전화번호" ).append("\n"); 
		query.append("|| 'EP_NM1:'    || PTY_NM1            ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 상호1" ).append("\n"); 
		query.append("|| 'EP_NM2'     || PTY_NM2            ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 상호2" ).append("\n"); 
		query.append("|| 'EP_ADDR1'   || PTY_ADDR1          ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 주소1" ).append("\n"); 
		query.append("|| 'EP_ADDR2'   || PTY_ADDR2          ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 주소2" ).append("\n"); 
		query.append("|| 'EP_ADDR3'   || PTY_ADDR3          ||'\\n' -- DO발급요청서 자가운송신청서 보세운송요청동의서 관련 업체 주소3" ).append("\n"); 
		query.append("FROM BKG_EDO_PTY_TRSP A" ).append("\n"); 
		query.append(", BKG_EDO_MST      B" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND B.VTY_FLG      = 'Y'" ).append("\n"); 
		query.append("AND B.EDO_TP_CD    = @[edo_tp_cd]" ).append("\n"); 
		query.append("#if (${edo_pty_cd} != '')" ).append("\n"); 
		query.append("AND EDO_PTY_CD     = @[edo_pty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}