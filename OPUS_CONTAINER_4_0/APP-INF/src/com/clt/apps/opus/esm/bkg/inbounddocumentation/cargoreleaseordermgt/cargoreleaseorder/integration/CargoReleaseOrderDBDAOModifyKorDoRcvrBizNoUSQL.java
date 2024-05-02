/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOModifyKorDoRcvrBizNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24 
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

public class CargoReleaseOrderDBDAOModifyKorDoRcvrBizNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DO 신정차 정보를 업데이트 한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOModifyKorDoRcvrBizNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOModifyKorDoRcvrBizNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_DO" ).append("\n"); 
		query.append("   SET RCVR_BIZ_NO  = ( SELECT MAX(EPTY.PTY_RGST_NO)      AS MS_PTY_RGST_NO        -- D/O 신청자   " ).append("\n"); 
		query.append("                        FROM ( SELECT /*+ USE_NL(IMST_MAX IMST) */" ).append("\n"); 
		query.append("                                        SUBSTR(MAX(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS')||IMST.EDO_RQST_NO),15) AS EDO_RQST_NO" ).append("\n"); 
		query.append("                                      , IMST.EDO_TP_CD" ).append("\n"); 
		query.append("                                      , SUBSTR(MAX( NVL(TO_CHAR(IMST.EDO_RCT_DT,'YYYYMMDDHH24MISS'), '00000000000000') ||CASE WHEN IMST.EDO_TP_CD = '5JN' THEN IMST.EDO_RQST_SEQ END),15) AS EDO_RQST_SEQ_5JN" ).append("\n"); 
		query.append("                                   FROM BKG_EDO_MST IMST" ).append("\n"); 
		query.append("                                  WHERE IMST.BKG_NO  =  @[bkg_no]" ).append("\n"); 
		query.append("                                    AND NVL(IMST.DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("                                  GROUP BY IMST.EDO_TP_CD" ).append("\n"); 
		query.append("                               )IMST" ).append("\n"); 
		query.append("                             , BKG_EDO_MST M5JN -- DO 신청" ).append("\n"); 
		query.append("                             , BKG_EDO_PTY_TRSP EPTY  -- 신청자 " ).append("\n"); 
		query.append("                         WHERE IMST.EDO_RQST_NO      = M5JN.EDO_RQST_NO" ).append("\n"); 
		query.append("                           AND IMST.EDO_RQST_SEQ_5JN = M5JN.EDO_RQST_SEQ" ).append("\n"); 
		query.append("                           AND EPTY.EDO_RQST_NO      = IMST.EDO_RQST_NO    " ).append("\n"); 
		query.append("                           AND EPTY.EDO_RQST_SEQ     = IMST.EDO_RQST_SEQ_5JN    " ).append("\n"); 
		query.append("                           AND EPTY.EDO_PTY_CD       = 'MS'   " ).append("\n"); 
		query.append("                         GROUP BY IMST.EDO_RQST_NO" ).append("\n"); 
		query.append("                       )     " ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND   RLSE_SEQ  = 1" ).append("\n"); 

	}
}