/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOModifyRqstFlgOfAdvJpSndLogUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier :
*@LastVersion : 1.0
* 2014.11.26
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOModifyRqstFlgOfAdvJpSndLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOModifyRqstFlgOfAdvJpSndLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n");
		query.append("FileName : Jp24CustomsTransmissionDBDAOModifyRqstFlgOfAdvJpSndLogUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_ADV_JP_SND_LOG" ).append("\n");
		query.append("" ).append("\n");
		query.append("   SET CSTMS_RQST_FLG = 'Y'," ).append("\n");
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n");
		query.append("       UPD_DT = SYSDATE" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE EDI_REF_ID = @[edi_ref_id]" ).append("\n");

	}
}