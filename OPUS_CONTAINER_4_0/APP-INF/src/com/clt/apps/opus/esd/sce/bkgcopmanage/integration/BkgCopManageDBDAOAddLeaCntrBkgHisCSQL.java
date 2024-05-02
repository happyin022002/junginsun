/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCopManageDBDAOAddLeaCntrBkgHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddLeaCntrBkgHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LEA_CNTR_BKG_HIS table 에 container 별 booking no 의 변경 history 를 insert 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOAddLeaCntrBkgHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_atch_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddLeaCntrBkgHisCSQL").append("\n"); 
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
		query.append("insert into lea_cntr_bkg_his (" ).append("\n"); 
		query.append("cntr_no," ).append("\n"); 
		query.append("bkg_his_seq," ).append("\n"); 
		query.append("bkg_no," ).append("\n"); 
		query.append("bkg_sts_cd," ).append("\n"); 
		query.append("cntr_atch_dt," ).append("\n"); 
		query.append("old_bkg_no," ).append("\n"); 
		query.append("old_bkg_sts_cd," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("rev_dir_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	select        	" ).append("\n"); 
		query.append("		 @[cntr_no]" ).append("\n"); 
		query.append("		,( select case when count(cntr_no) = 0 then 1 else max(bkg_his_seq)+1 end from lea_cntr_bkg_his where cntr_no = @[cntr_no] )" ).append("\n"); 
		query.append("		,bk.bkg_no" ).append("\n"); 
		query.append("		,bk.bkg_sts_cd" ).append("\n"); 
		query.append("		,NVL(TO_DATE(@[cntr_atch_dt],'YYYYMMDDHH24MISS'), sysdate)" ).append("\n"); 
		query.append("		,@[old_bkg_no]" ).append("\n"); 
		query.append("		,@[old_bkg_sts_cd]" ).append("\n"); 
		query.append("		,sysdate" ).append("\n"); 
		query.append("		,sysdate" ).append("\n"); 
		query.append("		,cbk.vsl_cd" ).append("\n"); 
		query.append("		,cbk.skd_voy_no" ).append("\n"); 
		query.append("		,cbk.dir_cd" ).append("\n"); 
		query.append("		,cbk.rev_dir_cd		" ).append("\n"); 
		query.append("	from bkg_booking bk, COA_RGST_BKG cbk  -- coa_bkg_info table 에서 변경됨" ).append("\n"); 
		query.append("	where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("		and bk.bkg_no = cbk.bkg_no(+)" ).append("\n"); 

	}
}