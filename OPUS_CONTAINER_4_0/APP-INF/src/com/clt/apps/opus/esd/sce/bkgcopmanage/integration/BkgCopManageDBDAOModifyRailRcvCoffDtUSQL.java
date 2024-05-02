/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyRailRcvCoffDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.23 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyRailRcvCoffDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Receiving cut off date 정보를 SCE_COP_HDR 에 update 한다.
	  * Batch DB 를 읽어야 하는 구조적인 문제로 BKG, SCE 가 commit 된 후 다시 update 하는 구조를 취하게 됨
	  * (OLTP DB 의 connection 을 열어 놓은 채로는 BATCH DB 의 connection 을 열 수 없음)
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyRailRcvCoffDtUSQL(){
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
		params.put("rail_rcv_coff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_rcv_coff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyRailRcvCoffDtUSQL").append("\n"); 
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
		query.append("update sce_cop_hdr" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("rail_rcv_coff_fm_dt = to_date(@[rail_rcv_coff_fm_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("rail_rcv_coff_to_dt = to_date(@[rail_rcv_coff_to_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cop_sts_cd != 'X'" ).append("\n"); 

	}
}