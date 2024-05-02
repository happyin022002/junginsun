/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMsnExistCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchMsnExistCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 같은 항차(vvd)에 empty b/l이 아닌 b/l에 중복되는 msn no.가 있으면 안되기 때문에 check한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMsnExistCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_number",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchMsnExistCntRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) CNT" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_BL A" ).append("\n"); 
		query.append("WHERE   A.VSL_CD    = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("AND A.POD_CD        = @[kt_port]" ).append("\n"); 
		query.append("AND A.CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n"); 
		query.append("AND A.DMST_PORT_CD  = @[kt_port]" ).append("\n"); 
		query.append("AND A.KR_CSTMS_BL_TP_CD  <> 'E'" ).append("\n"); 
		query.append("AND A.MST_BL_SEQ_NO    = TRIM(TO_CHAR(@[msn_number],'0000'))" ).append("\n"); 
		query.append("AND A.TRNS_SEQ = ( SELECT  MAX(TRANS.TRNS_SEQ)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_BL TRANS" ).append("\n"); 
		query.append("WHERE   TRANS.BKG_NO    = A.BKG_NO" ).append("\n"); 
		query.append("AND TRANS.DMST_PORT_CD  = A.DMST_PORT_CD" ).append("\n"); 
		query.append("AND TRANS.VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("AND TRANS.SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND TRANS.SKD_DIR_CD    = A.SKD_DIR_CD)" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,' ') <> 'Y'" ).append("\n"); 

	}
}