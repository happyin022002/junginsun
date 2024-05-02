/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifySceCopDetailEstmDtByBoundUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifySceCopDetailEstmDtByBoundUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySceCopDetailEstmDtByBound
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifySceCopDetailEstmDtByBoundUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_evnt_proc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_evnt_gap_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifySceCopDetailEstmDtByBoundUSQL").append("\n"); 
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
		query.append("UPDATE sce_cop_dtl" ).append("\n"); 
		query.append("SET   estm_dt    = estm_dt + TO_NUMBER(@[rcv_evnt_gap_desc])" ).append("\n"); 
		query.append("     ,estm_gdt   = estm_gdt + TO_NUMBER(@[rcv_evnt_gap_desc])" ).append("\n"); 
		query.append("     ,upd_dt     = SYSDATE" ).append("\n"); 
		query.append("     ,upd_usr_id = SUBSTR(@[cre_usr_id]||'SKD',1,20)" ).append("\n"); 
		query.append("WHERE cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND    (((COP_NO||COP_DTL_SEQ)  >= (@[cop_no]||@[fm_cop_dtl_seq])  AND  SUBSTR(@[rcv_evnt_proc_flg],2,1) = 'E')" ).append("\n"); 
		query.append("  OR   ((COP_NO||COP_DTL_SEQ)  >  (@[cop_no]||@[fm_cop_dtl_seq])  AND  SUBSTR(@[rcv_evnt_proc_flg],2,1) = 'A'))" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ  <  @[to_cop_dtl_seq]" ).append("\n"); 

	}
}