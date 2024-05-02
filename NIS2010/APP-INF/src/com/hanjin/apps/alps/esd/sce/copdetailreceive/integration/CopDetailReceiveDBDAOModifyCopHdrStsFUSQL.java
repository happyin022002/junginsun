/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyCopHdrStsFUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.13 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOModifyCopHdrStsFUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCopHdrStsF
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyCopHdrStsFUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_COP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_dtl_seq) ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyCopHdrStsFUSQL").append("\n"); 
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
		query.append("update  sce_cop_hdr" ).append("\n"); 
		query.append("           set  cop_sts_cd  = 'F'" ).append("\n"); 
		query.append("                ,upd_dt      = SYSDATE" ).append("\n"); 
		query.append("                ,upd_usr_id  = 'MVMT Close'" ).append("\n"); 
		query.append("         where  cop_no      = @[IN_COP_NO] AND COP_STS_CD != 'X'" ).append("\n"); 
		query.append("           and  (cop_no, @[v_cop_dtl_seq) ]) IN" ).append("\n"); 
		query.append("                    (select cop_no" ).append("\n"); 
		query.append("                            ,max(trim(cop_dtl_seq))" ).append("\n"); 
		query.append("                      from  sce_cop_dtl" ).append("\n"); 
		query.append("                     where  cop_no = @[IN_COP_NO]" ).append("\n"); 
		query.append("                     group  by cop_no" ).append("\n"); 
		query.append("                    )" ).append("\n"); 

	}
}