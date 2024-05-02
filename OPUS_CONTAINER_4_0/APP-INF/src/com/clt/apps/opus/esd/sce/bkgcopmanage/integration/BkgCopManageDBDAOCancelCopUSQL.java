/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOCancelCopUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.16 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCancelCopUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking no 에 해당하는 COP 를 cancel 처리한다. 단 flgDummy flag 에 따라 dummy cop (container no 가 없는) cop 만 cancel 할 지 결정한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCancelCopUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCancelCopUSQL").append("\n"); 
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
		query.append("cop_sts_cd = 'X'," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("#if(${flg_dummy} != '' && ${flg_dummy} == 'Y')" ).append("\n"); 
		query.append("and cntr_no = 'COMU0000000'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}