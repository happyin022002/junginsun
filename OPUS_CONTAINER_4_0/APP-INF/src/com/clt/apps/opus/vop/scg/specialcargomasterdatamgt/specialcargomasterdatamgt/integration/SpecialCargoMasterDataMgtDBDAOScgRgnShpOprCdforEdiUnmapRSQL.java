/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdforEdiUnmapRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdforEdiUnmapRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Unmap 용도의 RSO 추출
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdforEdiUnmapRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdforEdiUnmapRSQL").append("\n"); 
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
		query.append("SELECT	*" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT   	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("  				,  	RGN_SHP_OPR_ABBR_DESC" ).append("\n"); 
		query.append("  				,  	RGN_SHP_OPR_DESC" ).append("\n"); 
		query.append("  				,  	NVL(DELT_FLG,'N')   	AS DELT_FLG" ).append("\n"); 
		query.append("  				,  	CRE_USR_ID" ).append("\n"); 
		query.append("  				,  	CRE_DT" ).append("\n"); 
		query.append("  				,  	UPD_USR_ID" ).append("\n"); 
		query.append("  				,  	UPD_DT" ).append("\n"); 
		query.append("		FROM   		SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("		WHERE  		DELT_FLG          		= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT   	'RST'        			AS RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("  				,  	'RSO FOR EDI Unmap'		AS RGN_SHP_OPR_ABBR_DESC" ).append("\n"); 
		query.append("  				,  	'RSO FOR EDI Unmap'  	AS RGN_SHP_OPR_DESC" ).append("\n"); 
		query.append("  				,  	'N'         			AS DELT_FLG" ).append("\n"); 
		query.append("  				,  	'SYSTEM'      			AS CRE_USR_ID" ).append("\n"); 
		query.append("  				,  	SYSDATE        			AS CRE_DT" ).append("\n"); 
		query.append("  				,  	'SYSTEM'      			AS UPD_USR_ID" ).append("\n"); 
		query.append("  				,  	SYSDATE        			AS UPD_DT" ).append("\n"); 
		query.append("		FROM   		DUAL" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY DECODE(RGN_SHP_OPR_CD,'RST','ZZZ',RGN_SHP_OPR_CD)	ASC" ).append("\n"); 

	}
}