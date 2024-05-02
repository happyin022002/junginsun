/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBkgDgCntrCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.26 박상훈
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

public class KorManifestListDBDAOsearchBkgDgCntrCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Danger CNTR Count정보를 구한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBkgDgCntrCntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBkgDgCntrCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT DC.CNTR_NO) CNTR_CNT" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DC, BKG_BOOKING BKG, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD	 	=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO	=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD	=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD		NOT	IN	('X','S')" ).append("\n"); 
		query.append("AND BKG.BKG_NO		=	DC.BKG_NO" ).append("\n"); 
		query.append("AND DC.CNTR_NO	  	    IS	NOT	NULL" ).append("\n"); 
		query.append("AND BV.BKG_NO		=	BKG.BKG_NO" ).append("\n"); 
		query.append("AND ((@[io_bnd_cd] = 'O' AND BV.POL_CD = @[pol_cd] AND BKG.POL_CD <> BV.POL_CD) OR" ).append("\n"); 
		query.append("(@[io_bnd_cd] = 'I' AND BV.POD_CD = @[pod_cd]))" ).append("\n"); 

	}
}