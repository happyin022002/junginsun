/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlByAutoIRGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.12.09 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlByAutoIRGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update new Auto Inland Route Guide Sequence
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlByAutoIRGUSQL(){
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
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlByAutoIRGUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("   SET ROUT_SEQ = TO_NUMBER(@[rout_seq])" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no] || '%'" ).append("\n"); 
		query.append(" AND PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append(" AND ROUT_SEQ = -1 -- 향후 Sequence 반영을 감안해 999999999에서 -1로 대체함" ).append("\n"); 
		query.append(" AND ROUT_ORG_NOD_CD  = @[rout_org_nod_cd]  -- 시작노드와 종료노드가 같으면 동일한 Route이므로 PC번호와 상관없이 Update" ).append("\n"); 
		query.append(" AND ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 

	}
}