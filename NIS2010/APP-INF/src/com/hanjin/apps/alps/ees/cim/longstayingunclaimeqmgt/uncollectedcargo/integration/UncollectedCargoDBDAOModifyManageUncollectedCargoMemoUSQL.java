/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOModifyManageUncollectedCargoMemoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOModifyManageUncollectedCargoMemoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관리자 메모 저장
	  * </pre>
	  */
	public UncollectedCargoDBDAOModifyManageUncollectedCargoMemoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ucCsNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("managerMemo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOModifyManageUncollectedCargoMemoUSQL").append("\n"); 
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
		query.append("UPDATE  CIM_UC_CGO_DTL" ).append("\n"); 
		query.append("#if     (${isAuthority} == '1')" ).append("\n"); 
		query.append("SET     UC_CGO_RHQ_MM_DESC = @[managerMemo]" ).append("\n"); 
		query.append("      , UC_CGO_RHQ_MM_DESC_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      , UC_CGO_RHQ_MM_DESC_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET     UC_CGO_HO_MM_DESC = @[managerMemo]" ).append("\n"); 
		query.append("      , UC_CGO_HO_MM_DESC_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      , UC_CGO_HO_MM_DESC_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE UC_CS_NO = @[ucCsNo]" ).append("\n"); 
		query.append("AND   BL_NO=@[blNo]" ).append("\n"); 

	}
}