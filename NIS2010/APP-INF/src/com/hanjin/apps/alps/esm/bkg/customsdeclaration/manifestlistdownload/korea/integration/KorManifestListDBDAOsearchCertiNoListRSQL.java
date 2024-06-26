/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCertiNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.27 박상훈
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

public class KorManifestListDBDAOsearchCertiNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete후 새롭게 Insert하기 위해 변수값 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCertiNoListRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchCertiNoListRSQL").append("\n"); 
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
		query.append("SELECT VVD_SEQ" ).append("\n"); 
		query.append(", NVL(MRN_NO||MRN_CHK_NO, ' ') MRN_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_DG_CGO_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD  = 'I'" ).append("\n"); 
		query.append("AND VVD_SEQ = (SELECT MAX(VVD_SEQ)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_DG_CGO_VVD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 

	}
}