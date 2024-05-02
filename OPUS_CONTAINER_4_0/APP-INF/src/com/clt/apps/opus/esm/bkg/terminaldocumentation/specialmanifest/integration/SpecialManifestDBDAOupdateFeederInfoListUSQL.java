/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOupdateFeederInfoListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier :
*@LastVersion : 1.0
* 2010.06.03
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOupdateFeederInfoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FEEDER 정보를 수정한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOupdateFeederInfoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vsl_lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_key",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAOupdateFeederInfoListUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_CD_CONV_CTNT SET" ).append("\n");
		query.append("ATTR_CTNT1 = @[fdr_vsl_lloyd_no]" ).append("\n");
		query.append(",	ATTR_CTNT2 = @[fdr_vsl_nm]" ).append("\n");
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n");
		query.append(",	UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE	CNT_CD = 'BE'" ).append("\n");
		query.append("AND	CSTMS_DIV_ID = 'EUR_DG_ANR_BARGE'" ).append("\n");
		query.append("AND	CSTMS_DIV_ID_SEQ = @[seq_key]" ).append("\n");

	}
}