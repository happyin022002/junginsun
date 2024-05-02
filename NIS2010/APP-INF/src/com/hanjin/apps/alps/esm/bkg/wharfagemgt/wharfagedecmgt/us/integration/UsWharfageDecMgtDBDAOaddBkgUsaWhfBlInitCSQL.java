/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfBlInitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOaddBkgUsaWhfBlInitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgUsaWhfBlInit
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOaddBkgUsaWhfBlInitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfBlInitCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_USA_WHF_BL (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",   PORT_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",   CSTMS_DESC" ).append("\n"); 
		query.append(",   ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT V.VSL_CD" ).append("\n"); 
		query.append("	      ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("	      ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("	      ,DECODE(@[io_bnd_cd], 'I', V.POD_CD, V.POL_CD) AS PORT_CD" ).append("\n"); 
		query.append("	      ,@[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("	      ,A.BL_NO" ).append("\n"); 
		query.append("	      ,C.CSTMS_DESC" ).append("\n"); 
		query.append("	      ,DECODE(@[io_bnd_cd], 'I', A.DEL_CD, A.POR_CD) AS ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("	      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("          ,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("	      ,BKG_BL_DOC C" ).append("\n"); 
		query.append("          ,BKG_VVD V" ).append("\n"); 
		query.append("	 WHERE A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("       AND A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("	   AND V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	   AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	   AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	   AND A.BL_NO > ' '" ).append("\n"); 
		query.append("	   AND A.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("	#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("	   AND V.POD_CD = @[port_cd]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	   AND V.POL_CD = @[port_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}