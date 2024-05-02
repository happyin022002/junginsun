/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Send SEQ 조회
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL").append("\n");
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
		query.append("SELECT  NVL(MAX(MF_SND_SEQ), 0) + 1 MAX_SEQ" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_SND_LOG" ).append("\n");
		query.append("WHERE   MSG_LOG_TP_ID = '5LI'" ).append("\n");
		query.append("AND SND_DT = TO_DATE(@[log_date], 'YYYYMMDD hh24:mi:ss')" ).append("\n");
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n");

	}
}