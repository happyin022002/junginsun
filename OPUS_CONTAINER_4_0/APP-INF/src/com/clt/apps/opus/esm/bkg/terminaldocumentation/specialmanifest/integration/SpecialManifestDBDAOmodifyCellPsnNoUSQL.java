/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOmodifyCellPsnNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.12.14 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOmodifyCellPsnNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public SpecialManifestDBDAOmodifyCellPsnNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cell_psn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOmodifyCellPsnNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("   SET A.CELL_PSN_NO       = @[cell_psn_no]" ).append("\n"); 
		query.append(" WHERE A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND A.BL_NO             = @[bl_no]" ).append("\n"); 
		query.append("   AND (A.CNTR_NO = @[cntr_no] OR CNTR_REF_NO = @[cntr_ref_no])" ).append("\n"); 
		query.append("   AND A.PORT_CD           IN (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD BB" ).append("\n"); 
		query.append("                                WHERE BB.VSL_CD     = A.VSL_CD    " ).append("\n"); 
		query.append("                                  AND BB.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND BB.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND NVL(BB.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                  AND BB.CLPT_SEQ > (SELECT MIN(CC.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                       FROM VSK_VSL_PORT_SKD CC" ).append("\n"); 
		query.append("                                                      WHERE VSL_CD      = A.VSL_CD     " ).append("\n"); 
		query.append("                                                        AND SKD_VOY_NO  = A.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                        AND SKD_DIR_CD  = A.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                        AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 

	}
}