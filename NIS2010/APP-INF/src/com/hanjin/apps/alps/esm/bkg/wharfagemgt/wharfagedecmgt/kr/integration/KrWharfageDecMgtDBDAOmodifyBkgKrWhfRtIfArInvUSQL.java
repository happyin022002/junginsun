/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfArInvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfArInvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20101201 이수진 한국지역 WHF DEC CANCEL 정보 유관 시스템 I/F 기능 추가
	  * => Dec I/F or Dec Cancel I/F 버튼 클릭 시 AR I/F Flag 유무, 날짜정보를 Update 해준다.
	  *      Dec I/F or Dec Cancel I/F 버튼 클릭 유무는 pagerows로 구분한다.
	  *      Cancle Flag를 추가해줘야 하는데 Table VO라서 안쓰는 VO로 대신 사용
	  *     즉 pagerows VO는 cancelFlag 대신 사용된 VO 임
	  *      
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfArInvUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfArInvUSQL").append("\n"); 
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
		query.append("UPDATE BKG_KR_WHF_RT A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pagerows} != 'Y')" ).append("\n"); 
		query.append("SET A.AR_IF_FLG = 'Y'," ).append("\n"); 
		query.append("A.AR_IF_DT = SYSDATE," ).append("\n"); 
		query.append("A.AR_IF_GDT = GLOBALDATE_PKG.TIME_CONV_FNC(PORT_CD, SYSDATE, 'GMT')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET A.AR_IF_FLG = 'N'," ).append("\n"); 
		query.append("A.AR_IF_DT = ''," ).append("\n"); 
		query.append("A.AR_IF_GDT = ''," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("A.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND A.CHG_RT_SEQ = (SELECT MAX(B.CHG_RT_SEQ) FROM BKG_KR_WHF_RT B WHERE B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.BL_NO = A.BL_NO)" ).append("\n"); 

	}
}