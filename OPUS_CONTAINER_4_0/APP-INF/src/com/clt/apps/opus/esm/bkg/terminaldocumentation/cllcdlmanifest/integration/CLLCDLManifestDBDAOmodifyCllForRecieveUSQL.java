/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOmodifyCllForRecieveUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOmodifyCllForRecieveUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyCllForRecieve
	  * </pre>
	  */
	public CLLCDLManifestDBDAOmodifyCllForRecieveUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vslvoy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vslcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsldir",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOmodifyCllForRecieveUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_TML_CLL" ).append("\n");
		query.append("SET	EDI_RCV_STS_CD	= 'Y'," ).append("\n");
		query.append("RSPN_MSG_RCV_DT		= SYSDATE," ).append("\n");
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n");
		query.append("UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE	VSL_CD	= @[in_vslcd]" ).append("\n");
		query.append("AND	SKD_VOY_NO	= @[in_vslvoy]" ).append("\n");
		query.append("AND	SKD_DIR_CD	= @[in_vsldir]" ).append("\n");
		query.append("AND	CNTR_NO		= @[in_cntr]" ).append("\n");

	}
}