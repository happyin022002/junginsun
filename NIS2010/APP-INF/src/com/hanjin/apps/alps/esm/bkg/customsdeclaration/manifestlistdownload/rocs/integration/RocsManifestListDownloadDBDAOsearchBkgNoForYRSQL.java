/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchBkgNoForYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.30 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchBkgNoForYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_no select
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchBkgNoForYRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE  BKG.BL_NO = substr(@[bl_no],0,12)" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("AND    BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND    BKG.BKG_CGO_TP_CD IN ('F','P','R','B')" ).append("\n"); 
		query.append("AND    DOC.BDR_FLG = 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchBkgNoForYRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}