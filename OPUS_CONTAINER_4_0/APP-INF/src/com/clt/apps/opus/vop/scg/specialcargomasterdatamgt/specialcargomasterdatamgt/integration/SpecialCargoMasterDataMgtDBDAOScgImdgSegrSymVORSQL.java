/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.08 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * No. & Symbols in SEG Table/Mixed STWG (Creation) 조회   
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(",	IMDG_SEGR_TP_CD" ).append("\n"); 
		query.append(",	IMDG_SEGR_CD" ).append("\n"); 
		query.append(",	IMDG_SEGR_DESC" ).append("\n"); 
		query.append(",	NVL(DELT_FLG,'N') AS DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append("FROM SCG_IMDG_SEGR_SYM" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_segr_tp_cd} != '')" ).append("\n"); 
		query.append("AND IMDG_SEGR_TP_CD = @[imdg_segr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_segr_cd} != '')" ).append("\n"); 
		query.append("AND	IMDG_SEGR_CD = @[imdg_segr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IMDG_SEGR_TP_CD, IMDG_SEGR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}