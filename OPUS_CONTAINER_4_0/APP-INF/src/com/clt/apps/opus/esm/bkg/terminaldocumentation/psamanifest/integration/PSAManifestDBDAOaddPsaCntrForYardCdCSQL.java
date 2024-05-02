/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOaddPsaCntrForYardCdCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.16
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOaddPsaCntrForYardCdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Yard Assign By CNTR화면에서 Row add시 insert한다.
	  * </pre>
	  */
	public PSAManifestDBDAOaddPsaCntrForYardCdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOaddPsaCntrForYardCdCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_PSA_CNTR" ).append("\n");
		query.append("(       BKG_NO          ," ).append("\n");
		query.append("BKG_SEQ         ," ).append("\n");
		query.append("PSA_SER_NO      ," ).append("\n");
		query.append("PSA_IF_CD       ," ).append("\n");
		query.append("DCGO_FLG        ," ).append("\n");
		query.append("RC_FLG          ," ).append("\n");
		query.append("RD_CGO_FLG      ," ).append("\n");
		query.append("OVR_HGT_FLG     ," ).append("\n");
		query.append("OVR_WDT_FLG     ," ).append("\n");
		query.append("OVR_LEN_FLG     ," ).append("\n");
		query.append("CRE_DT          ," ).append("\n");
		query.append("CRE_USR_ID      ," ).append("\n");
		query.append("UPD_DT          ," ).append("\n");
		query.append("UPD_USR_ID   )" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(       @[bkg_no]       ," ).append("\n");
		query.append("@[bkg_seq] + 1  ," ).append("\n");
		query.append("1               ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("'N'             ," ).append("\n");
		query.append("SYSDATE         ," ).append("\n");
		query.append("@[usr_id]       ," ).append("\n");
		query.append("SYSDATE         ," ).append("\n");
		query.append("@[usr_id]       )" ).append("\n");

	}
}