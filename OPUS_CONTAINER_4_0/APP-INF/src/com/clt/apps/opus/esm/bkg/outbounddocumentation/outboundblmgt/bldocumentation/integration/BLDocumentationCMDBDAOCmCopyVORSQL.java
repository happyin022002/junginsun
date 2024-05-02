/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.20 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select   
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmCopyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_vsl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmCopyVORSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      B.MF_CFM_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    A.VSL_CD = @[vvd_vsl]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[vvd_voy]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[vvd_dir]" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    A.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_pol} != '')" ).append("\n"); 
		query.append("AND    A.POL_CD = @[bkg_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_pod} != '')" ).append("\n"); 
		query.append("AND    A.POD_CD = @[bkg_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cfm_flg} != '' && ${cfm_flg} != 'A')" ).append("\n"); 
		query.append("AND    b.mf_cfm_flg = @[cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.CNTR_DP_SEQ" ).append("\n"); 

	}
}