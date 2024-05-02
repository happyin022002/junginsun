/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMrnValidChkRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.26 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchMrnValidChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MRN 체크
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMrnValidChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchMrnValidChkRSQL").append("\n");
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
		query.append("SELECT COUNT(*) MRN_CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n");
		query.append("WHERE VSL_CD	  =	SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO =	SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD =	SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND PORT_CD    =	DECODE(@[io_bnd_cd], 'O', @[pol_cd], @[pod_cd])" ).append("\n");
		query.append("AND IO_BND_CD  =	@[io_bnd_cd]" ).append("\n");
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n");

	}
}