/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyEDIMsnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.19 박상훈
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

public class KorManifestListDBDAOmodifyEDIMsnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 전송후 MSN UPDATE
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyEDIMsnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOmodifyEDIMsnUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n"); 
		query.append("SET SND_DT  = SYSDATE" ).append("\n"); 
		query.append("WHERE (BKG_NO, MF_REF_NO) IN (" ).append("\n"); 
		query.append("SELECT  A.BKG_NO, A.MF_REF_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_MF_SEQ_NO A, BKG_VVD B, BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE   B.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND     B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     B.POD_CD     = @[port_cd]" ).append("\n"); 
		query.append("AND     B.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("AND     C.BKG_NO     = A.BKG_NO" ).append("\n"); 
		query.append("AND     A.MF_REF_NO  = @[mrn_no]" ).append("\n"); 
		query.append("AND     (A.SND_DT IS NULL OR A.SND_DT < A.UPD_DT ) )" ).append("\n"); 

	}
}