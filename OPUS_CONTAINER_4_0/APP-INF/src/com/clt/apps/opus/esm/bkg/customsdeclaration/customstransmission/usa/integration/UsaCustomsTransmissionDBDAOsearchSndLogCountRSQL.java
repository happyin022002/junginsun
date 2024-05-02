/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.23 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchSndLogCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_SND_LOG A" ).append("\n"); 
		query.append(" WHERE VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND POD_CD      = @[pod]" ).append("\n"); 
		query.append("   AND POL_CD      = NVL(@[pol], POL_CD)" ).append("\n"); 
		query.append("   AND TRSM_MSG_TP_ID = @[trsm_tp]" ).append("\n"); 
		query.append("   AND IO_BND_CD      = 'I'" ).append("\n"); 
		query.append("   AND DELT_FLG       = 'N'" ).append("\n"); 
		query.append("   AND CNT_CD         = 'US'" ).append("\n"); 
		query.append("   AND NVL(CGO_TP_CD, 'X') = DECODE(NVL(CGO_TP_CD,'X'), 'X', 'X', NVL(@[cgo_tp_cd], CGO_TP_CD))" ).append("\n"); 
		query.append("#if (${trsm_tp} == 'MI') " ).append("\n"); 
		query.append("   --RCV_LOG에 데이타가 없거나, ACCECPT 받은 BL이 한건이라도 있는 경우" ).append("\n"); 
		query.append("   AND (SELECT (SELECT COUNT(B.BL_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append("                 WHERE B.CNT_CD     = A.CNT_CD" ).append("\n"); 
		query.append("                   AND B.CRR_BAT_NO = A.CRR_BAT_NO" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("               -" ).append("\n"); 
		query.append("               (SELECT COUNT(DISTINCT D.BL_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RCV_LOG     B" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_RCV_LOG_DTL C" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_EDI_BL_RSPN D" ).append("\n"); 
		query.append("                 WHERE B.CNT_CD     = A.CNT_CD" ).append("\n"); 
		query.append("                   AND B.CRR_BAT_NO = A.CRR_BAT_NO" ).append("\n"); 
		query.append("                   AND B.CNT_CD     = C.CNT_CD" ).append("\n"); 
		query.append("                   AND B.IO_BND_CD  = C.IO_BND_CD" ).append("\n"); 
		query.append("                   AND B.RCV_DT     = C.RCV_DT" ).append("\n"); 
		query.append("                   AND B.RCV_SEQ    = C.RCV_SEQ" ).append("\n"); 
		query.append("                   AND D.CNT_CD     = A.CNT_CD" ).append("\n"); 
		query.append("                   AND D.CRR_BAT_NO = A.CRR_BAT_NO" ).append("\n"); 
		query.append("                   AND C.MSG_DESC LIKE 'W01' || D.BL_NO || '%'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        ) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}