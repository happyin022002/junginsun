/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_dt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_dt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_dt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_dt1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_tbl_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_val1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_CD (" ).append("\n"); 
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
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cd_tbl_id]" ).append("\n"); 
		query.append(",	@[val_cd]" ).append("\n"); 
		query.append(",	@[cd_nm]" ).append("\n"); 
		query.append(",	@[attr_ctnt1]" ).append("\n"); 
		query.append(",	@[attr_ctnt2]" ).append("\n"); 
		query.append(",	@[attr_ctnt3]" ).append("\n"); 
		query.append(",	@[attr_ctnt4]" ).append("\n"); 
		query.append(",	@[attr_ctnt5]" ).append("\n"); 
		query.append(",	@[attr_ctnt6]" ).append("\n"); 
		query.append(",	@[attr_ctnt7]" ).append("\n"); 
		query.append(",	@[attr_ctnt8]" ).append("\n"); 
		query.append(",	@[attr_ctnt9]" ).append("\n"); 
		query.append(",	@[attr_ctnt10]" ).append("\n"); 
		query.append(",	@[attr_val1]" ).append("\n"); 
		query.append(",	@[attr_val2]" ).append("\n"); 
		query.append(",	@[attr_val3]" ).append("\n"); 
		query.append(",	@[attr_val4]" ).append("\n"); 
		query.append(",	@[attr_val5]" ).append("\n"); 
		query.append(",	@[attr_val6]" ).append("\n"); 
		query.append(",	@[attr_val7]" ).append("\n"); 
		query.append(",	@[attr_val8]" ).append("\n"); 
		query.append(",	@[attr_val9]" ).append("\n"); 
		query.append(",	@[attr_val10]" ).append("\n"); 
		query.append(",	TO_DATE(@[attr_dt1],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[attr_dt2],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[attr_dt3],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[attr_dt4],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[attr_dt5],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}