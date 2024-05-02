/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.09
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBkgCntrSealNo
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL").append("\n");
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
		query.append("SELECT  BB.BL_NO					AS BL_NO," ).append("\n");
		query.append("BC.CNTR_NO					AS CNTR_NO," ).append("\n");
		query.append("NVL(CS.CNTR_SEAL_NO, ' ') 	AS SEAL_NO," ).append("\n");
		query.append("CS.SEAL_PTY_TP_CD 			AS SEAL_PTY_TP_CD," ).append("\n");
		query.append("CS.SEAL_KND_CD				AS SEAL_KND_CD," ).append("\n");
		query.append("@[usr_id]					AS CRE_USR_ID," ).append("\n");
		query.append("@[usr_id]					AS UPD_USR_ID" ).append("\n");
		query.append("FROM	BKG_CONTAINER BC," ).append("\n");
		query.append("BKG_CNTR_SEAL_NO CS," ).append("\n");
		query.append("BKG_BOOKING BB" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n");
		query.append("#if($velocityCount > 1)" ).append("\n");
		query.append("OR #end      BB.BKG_NO IN ( $field_id )" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#if (${bkg_cgo_tp_cd} != '')" ).append("\n");
		query.append("AND     DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND	    BB.BKG_NO = BC.BKG_NO" ).append("\n");
		query.append("AND	    BC.BKG_NO = CS.BKG_NO" ).append("\n");
		query.append("AND	    BC.CNTR_NO = CS.CNTR_NO" ).append("\n");

	}
}