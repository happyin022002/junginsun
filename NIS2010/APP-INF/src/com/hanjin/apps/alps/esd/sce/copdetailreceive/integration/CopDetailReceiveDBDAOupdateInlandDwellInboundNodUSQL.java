/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOupdateInlandDwellInboundNodUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOupdateInlandDwellInboundNodUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Inbound Node의 Plan Date 업데이트
	  * </pre>
	  */
	public CopDetailReceiveDBDAOupdateInlandDwellInboundNodUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOupdateInlandDwellInboundNodUSQL").append("\n"); 
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
		query.append("UPDATE	SCE_COP_DTL  D" ).append("\n"); 
		query.append("SET	    D.FX_PLN_DT =" ).append("\n"); 
		query.append("D.PLN_DT    +" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FX_PLN_DT   -   PLN_DT" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL DD" ).append("\n"); 
		query.append("WHERE   DD.COP_NO		=	@[cop_no]" ).append("\n"); 
		query.append("AND		DD.COP_DTL_SEQ  >	@[fm_cop_dtl_seq]" ).append("\n"); 
		query.append("AND     DD.NOD_CD       =   @[nod_cd]" ).append("\n"); 
		query.append("AND     DD.ACT_CD       LIKE    '____DO'" ).append("\n"); 
		query.append("AND     ROWNUM          =   1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	D.COP_NO	=	@[cop_no]" ).append("\n"); 
		query.append("AND	D.COP_DTL_SEQ	>	@[fm_cop_dtl_seq]" ).append("\n"); 
		query.append("AND     D.NOD_CD        <>  @[nod_cd]" ).append("\n"); 

	}
}