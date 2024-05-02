/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddTmlCllForRecieveCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddTmlCllForRecieveCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addTmlCllForRecieve
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddTmlCllForRecieveCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOaddTmlCllForRecieveCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_TML_CLL" ).append("\n");
		query.append("(VSL_CD," ).append("\n");
		query.append("SKD_VOY_NO," ).append("\n");
		query.append("SKD_DIR_CD," ).append("\n");
		query.append("PORT_CD," ).append("\n");
		query.append("BKG_NO," ).append("\n");
		query.append("CNTR_NO," ).append("\n");
		query.append("CNTR_LODG_NO," ).append("\n");
		query.append("RSPN_MSG_RCV_DT," ).append("\n");
		query.append("EDI_RCV_STS_CD," ).append("\n");
		query.append("CFM_FLG," ).append("\n");
		query.append("TEU_CNTR_QTY," ).append("\n");
		query.append("FEU_CNTR_QTY," ).append("\n");
		query.append("RC_FLG," ).append("\n");
		query.append("DCGO_FLG," ).append("\n");
		query.append("AWK_CGO_FLG," ).append("\n");
		query.append("BB_CGO_FLG," ).append("\n");
		query.append("RD_CGO_FLG," ).append("\n");
		query.append("PCK_QTY," ).append("\n");
		query.append("CNTR_WGT," ).append("\n");
		query.append("GRS_CNTR_WGT," ).append("\n");
		query.append("OVR_CNTR_WGT," ).append("\n");
		query.append("TARE_CNTR_WGT," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("UPD_USR_ID," ).append("\n");
		query.append("UPD_DT)" ).append("\n");
		query.append("VALUES	(NVL(@[vsl_cd],'XXXX')," ).append("\n");
		query.append("NVL(@[skd_voy_no],'0000')," ).append("\n");
		query.append("NVL(@[skd_dir_cd],'A')," ).append("\n");
		query.append("NVL(@[port_cd],'KRSGC')," ).append("\n");
		query.append("NVL(@[bkg_no],'XXXXXXXXXXX  ')," ).append("\n");
		query.append("NVL(@[cntr_no],'XXXX0000001')," ).append("\n");
		query.append("TO_CHAR(SYSDATE,'DDHH24MI')||'0000'," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("'I'," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("0," ).append("\n");
		query.append("0," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("'N'," ).append("\n");
		query.append("0," ).append("\n");
		query.append("0," ).append("\n");
		query.append("0," ).append("\n");
		query.append("0," ).append("\n");
		query.append("0," ).append("\n");
		query.append("RTRIM(@[cre_usr_id])," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("RTRIM(@[cre_usr_id])," ).append("\n");
		query.append("SYSDATE)" ).append("\n");

	}
}