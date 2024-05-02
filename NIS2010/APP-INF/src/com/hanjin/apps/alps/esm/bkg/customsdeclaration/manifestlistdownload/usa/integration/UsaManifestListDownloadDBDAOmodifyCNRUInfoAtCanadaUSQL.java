/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyCNRUInfoAtCanadaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyCNRUInfoAtCanadaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyCNRUInfoAtCanadaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_et_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_nvobl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_snp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hjbl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyCNRUInfoAtCanadaUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_CNTR" ).append("\n"); 
		query.append("   SET RAIL_CRR_REF_NO = @[in_snp] || @[in_nvobl]" ).append("\n"); 
		query.append("      ,USA_IB_TRSP_NO = DECODE(@[icr_code], '69', TRIM(@[icr_et_no]), '55', TRIM(@[icr_et_no]), USA_IB_TRSP_NO)" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND BL_NO in( substr(@[in_hjbl], 5, 12) , substr(@[in_hjbl], 1, 12)  )" ).append("\n"); 
		query.append("   AND CNTR_NO LIKE TRIM(@[in_cntr]) || '%'" ).append("\n"); 
		query.append("   AND @[in_snp] IN ( SELECT ATTR_CTNT1 FROM " ).append("\n"); 
		query.append("						BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("						WHERE CNT_CD='US'" ).append("\n"); 
		query.append("						AND CSTMS_DIV_ID='US_CA_RAIL_CMPY_CD'" ).append("\n"); 
		query.append("						)" ).append("\n"); 

	}
}