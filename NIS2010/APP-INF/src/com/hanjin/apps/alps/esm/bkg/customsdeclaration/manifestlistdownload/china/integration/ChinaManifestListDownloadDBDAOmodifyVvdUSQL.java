/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOmodifyVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOmodifyVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyVvd
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOmodifyVvdUSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOmodifyVvdUSQL").append("\n"); 
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
		query.append("UPDATE	BKG_CSTMS_CHN_VVD SV" ).append("\n"); 
		query.append("SET     SV.MF_SND_DT		  = ( SELECT MF_SND_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  *" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG" ).append("\n"); 
		query.append("WHERE   VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND     CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("#if (${trans_mode} == 'D')" ).append("\n"); 
		query.append("AND		BKG_POL_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MF_SND_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   ROWNUM = 1 )" ).append("\n"); 
		query.append(",SV.MF_SND_USR_ID      =	@[usr_id]" ).append("\n"); 
		query.append("WHERE	SV.VSL_CD		      =	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	    SV.SKD_VOY_NO	      =	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	    SV.SKD_DIR_CD	      =	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${trans_mode} == 'D')" ).append("\n"); 
		query.append("AND	    SV.PORT_CD		      IN ( @[loc_cd], @[pol] )" ).append("\n"); 
		query.append("AND	    SV.CHN_MF_SND_IND_CD  IN ( @[trans_mode], 'R' ) /*24hr*/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	    SV.PORT_CD		      = @[loc_cd]" ).append("\n"); 
		query.append("AND	    SV.CHN_MF_SND_IND_CD  = @[trans_mode] /*24hr*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}