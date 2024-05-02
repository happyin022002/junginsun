/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.04 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_tbl_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgCdVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CD_TBL_ID" ).append("\n"); 
		query.append(",	VAL_CD" ).append("\n"); 
		query.append(",	CD_NM" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_VAL1" ).append("\n"); 
		query.append(",	ATTR_VAL2" ).append("\n"); 
		query.append(",	ATTR_VAL3" ).append("\n"); 
		query.append(",	ATTR_VAL4" ).append("\n"); 
		query.append(",	ATTR_VAL5" ).append("\n"); 
		query.append(",	ATTR_VAL6" ).append("\n"); 
		query.append(",	ATTR_VAL7" ).append("\n"); 
		query.append(",	ATTR_VAL8" ).append("\n"); 
		query.append(",	ATTR_VAL9" ).append("\n"); 
		query.append(",	ATTR_VAL10" ).append("\n"); 
		query.append(",	ATTR_DT1" ).append("\n"); 
		query.append(",	ATTR_DT2" ).append("\n"); 
		query.append(",	ATTR_DT3" ).append("\n"); 
		query.append(",	ATTR_DT4" ).append("\n"); 
		query.append(",	ATTR_DT5" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append("FROM SCG_CD" ).append("\n"); 
		query.append("WHERE	CD_TBL_ID = @[cd_tbl_id]" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${val_cd} != '') " ).append("\n"); 
		query.append("AND	VAL_CD like @[val_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cd_nm} != '') " ).append("\n"); 
		query.append("AND	UPPER(CD_NM) like UPPER(@[cd_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '') " ).append("\n"); 
		query.append("AND	ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt2} != '') " ).append("\n"); 
		query.append("AND	ATTR_CTNT2 = @[attr_ctnt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}