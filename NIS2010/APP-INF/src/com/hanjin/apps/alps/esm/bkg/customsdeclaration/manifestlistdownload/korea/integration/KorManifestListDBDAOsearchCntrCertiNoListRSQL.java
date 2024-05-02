/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCntrCertiNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchCntrCertiNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Certi No 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCntrCertiNoListRSQL(){
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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchCntrCertiNoListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(A,3,LENGTH(A)-2) CERTI_NO" ).append("\n"); 
		query.append(", B CERTI_SEQ_NO" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT MAX(TO_CHAR(CNT.CNTR_SEQ,'FM00')||VVD.MRN_NO||VVD.MRN_CHK_NO) A," ).append("\n"); 
		query.append("MAX(TRIM(TO_CHAR(CNT.DCGO_SEQ,'000'))) B" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_DG_CGO CNT, BKG_CSTMS_KR_DG_CGO_VVD VVD" ).append("\n"); 
		query.append("WHERE  CNT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CNT.CSTMS_DECL_TP_CD = 'T'" ).append("\n"); 
		query.append("AND    CNT.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    CNT.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND    CNT.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("AND    CNT.CNTR_SEQ = VVD.VVD_SEQ" ).append("\n"); 
		query.append("AND    CNT.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND    CNT.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    CNT.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    VVD.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND    VVD.PORT_CD = @[port_cd])" ).append("\n"); 

	}
}