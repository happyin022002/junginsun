/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchSubNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchSubNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Submit No를 구한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchSubNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestListDBDAOsearchSubNoRSQL").append("\n"); 
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
		query.append("SELECT  KV.MRN_NO||KV.MRN_CHK_NO||'SMLM'||LTRIM(TO_CHAR(NVL(MAX(SUBSTR(KC.SMT_AMD_NO, 16, 4)), 0) + 1, '0000')) SUB_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_CORR KC, BKG_CSTMS_ADV_KR_VVD_SMRY KV" ).append("\n"); 
		query.append("WHERE   KV.vsl_cd       = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("AND KV.skd_voy_no       = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("AND KV.skd_dir_cd       = SUBSTR(@[in_vvd], 9, 1)" ).append("\n"); 
		query.append("AND KV.IO_BND_CD        = 'I'" ).append("\n"); 
		query.append("AND KV.PORT_CD          = @[ib_port] /* UI_BKG_329에서 넘겨받은 parm */" ).append("\n"); 
		query.append("AND NVL(KV.PORT_TML_CD,' ')= @[pod_tml_cd]" ).append("\n"); 
		query.append("AND KC.SMT_AMD_NO(+)    LIKE KV.MRN_NO||KV.MRN_CHK_NO||'SMLM'||'%'" ).append("\n"); 
		query.append("AND KC.AMDT_SND_DT(+)   IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY KV.MRN_NO, KV.MRN_CHK_NO" ).append("\n"); 

	}
}