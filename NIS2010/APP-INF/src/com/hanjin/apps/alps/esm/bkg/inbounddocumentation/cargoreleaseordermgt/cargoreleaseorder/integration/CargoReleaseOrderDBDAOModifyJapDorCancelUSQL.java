/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOModifyJapDorCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2010.01.08 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOModifyJapDorCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로 전송을 요청한 상태 코드를 CANCEL(X) 상태로 변경한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOModifyJapDorCancelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOModifyJapDorCancelUSQL").append("\n"); 
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
		query.append("UPDATE BKG_JP_DO_IF" ).append("\n"); 
		query.append("SET JP_DO_GRP_NO='-1'" ).append("\n"); 
		query.append(",JP_DO_SND_STS_CD ='X'" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO      =@[bkg_no]" ).append("\n"); 
		query.append("AND RLSE_SEQ    =@[rlse_seq]" ).append("\n"); 
		query.append("AND DO_IF_SEQ = ( SELECT MAX(DO_IF_SEQ)" ).append("\n"); 
		query.append("FROM BKG_JP_DO_IF" ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND RLSE_SEQ=@[rlse_seq]" ).append("\n"); 
		query.append("AND JP_DO_SND_STS_CD ='T'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}