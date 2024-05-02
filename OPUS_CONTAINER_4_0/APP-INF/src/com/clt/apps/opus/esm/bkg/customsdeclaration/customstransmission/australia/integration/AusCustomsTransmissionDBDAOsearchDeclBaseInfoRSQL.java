/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reason_resending",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL").append("\n"); 
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
		query.append("SELECT '89N' AS DOC_NAME," ).append("\n"); 
		query.append("       @[d_type] AS HANDLING," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(*), 0, 'O', 'U') AS SEND_STATUS" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_DG_SND" ).append("\n"); 
		query.append("         WHERE AUS_SND_LOG_ID = 'IFD'" ).append("\n"); 
		query.append("           AND PSA_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("           AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND PORT_CD = @[port_cd] ) AS STATUS," ).append("\n"); 
		query.append("       -- Cancel전송 클릭 시 'C', 최초전송이면 'O', BKG_CSTMS_EUR_DG_SND_LOG에 존재하면 'U'" ).append("\n"); 
		query.append("       NVL(@[reason_resending], '') AS REASON," ).append("\n"); 
		query.append("       '' AS USER_REF," ).append("\n"); 
		query.append("       -- 전송로그 MSN_SND_NO를 사용함" ).append("\n"); 
		query.append("       '' AS OLD_USER_REF," ).append("\n"); 
		query.append("       '' AS FIRST_USER_REF," ).append("\n"); 
		query.append("       '' AS SEC_FILE_NBR," ).append("\n"); 
		query.append("       '' AS FF_REF -- 확인 요망" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}