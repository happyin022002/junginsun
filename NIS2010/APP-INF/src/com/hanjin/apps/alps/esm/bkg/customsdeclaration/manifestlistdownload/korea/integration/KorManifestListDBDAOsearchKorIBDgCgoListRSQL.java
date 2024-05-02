/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchKorIBDgCgoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchKorIBDgCgoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * I/B CNTR Info를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchKorIBDgCgoListRSQL(){
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
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchKorIBDgCgoListRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("     , CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , LPAD(CGO_SEQ_NO,3,'0') IB_SEQ" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , TO_CHAR(CNTR_SEQ, '00000')||CNTR_SEQ CNTR_SEQ" ).append("\n"); 
		query.append("     , IMDG_UN_NO" ).append("\n"); 
		query.append("     , MSN_NO" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , MF_CERTI_NO CERTI_NO" ).append("\n"); 
		query.append("     , DCHG_KND_CD JOB" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , PRP_SHP_NM SUBSTANCE" ).append("\n"); 
		query.append("     , NET_WGT NET_WEIGHT" ).append("\n"); 
		query.append("     , DECODE(SND_DT, NULL, 'N', 'Y') SND_CHK" ).append("\n"); 
		query.append("     , CERTI_SEQ_NO" ).append("\n"); 
		query.append("     , IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_KR_DG_CGO" ).append("\n"); 
		query.append("WHERE	VSL_CD			=	SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	    =	SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND		SKD_DIR_CD		=	SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND     POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("AND		(@[io_bnd_cd]   = 'I' AND CSTMS_DECL_TP_CD IN ('I', 'T'))" ).append("\n"); 
		query.append("AND		CNTR_SEQ		=	@[cntr_seq]" ).append("\n"); 

	}
}