/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchBkgCstmsEurDgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchBkgCstmsEurDgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCstmsEurDgList
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchBkgCstmsEurDgListRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_dg_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchBkgCstmsEurDgListRSQL").append("\n"); 
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
		query.append("SELECT  A.EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.PORT_CD" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",A.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${sch_type} == 'bkg_no')" ).append("\n"); 
		query.append("AND  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif (${sch_type} != 'bl_no')" ).append("\n"); 
		query.append("AND  A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eur_dg_decl_tp_cd} != '')" ).append("\n"); 
		query.append("AND  A.EUR_DG_DECL_TP_CD = @[eur_dg_decl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}