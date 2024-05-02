/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *ProcessChain    : NPI
 *@FileName       : ExcelDataBCImpl.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Sep 22, 2009
 *@LastModifier   : Jeong-Hoon, KIM
 *@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.file.exceldownload.basic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * It's ExcelDataBCImpl.java
 * 
 * @author Jeong-Hoon, KIM
 * @see
 * @since J2EE 1.5 Sep 22, 2009
 */
public class ExcelDataBCImpl implements ExcelDataBC{

	/**
	 * 
	 * getColumns
	 * @author Jeong-Hoon, KIM
	 * @return String[]
	 */
	public String[] getColumns() {
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		String[] titleField = new String[7];
		titleField[0] = "ibflag";
		titleField[1] = "vsl_cd";
		titleField[2] = "pol_cd";
		titleField[3] = "pod_cd";
		titleField[4] = "skd_dir_cd";
		titleField[5] = "skd_voy_no";
		titleField[6] = "pagerows";
		return titleField;
	}

	/**
	 * 
	 * getTitle
	 * @author Jeong-Hoon, KIM
	 * @return String[]
	 */
	public String[] getTitle() {
		// 엑셀의 컬럼헤더 정의
		String[] title = new String[7];
		title[0] = "COL1";
		title[1] = "COL2";
		title[2] = "COL3";
		title[3] = "COL4";
		title[4] = "COL5";
		title[5] = "COL6";
		title[6] = "COL7";
		return title;
	}

	/**
	 * 
	 * getVOs
	 * @author Jeong-Hoon, KIM
	 * @return List<?>
	 */
	public List<?> getVOs() { // 객체 생성..
		List<AbstractValueObject> vos = new ArrayList<AbstractValueObject>();
		for (int i = 0; i < 50000; i++) {
			ManilaManifestListCondVO vo = new ManilaManifestListCondVO();
			vo.setIbflag("U");
			vo.setVslCd("20");
			vo.setPod("KKK");
			vo.setPol("PPP");
			vo.setSkdVoyNo("REGNO");
			vo.setSkdDirCd("CCC");
			vo.setPagerows("3");

			ManilaManifestListCondVO vo1 = new ManilaManifestListCondVO();
			vo1.setIbflag("U1");
			vo1.setVslCd("201");
			vo1.setPod("KKK1");
			vo1.setPol("PPP1");
			vo1.setSkdVoyNo("REGNO1");
			vo1.setSkdDirCd("CCC1");
			vo1.setPagerows("31");
			vos.add(vo);
			vos.add(vo1);
		}
		return vos;
	}

	/**
	 * 
	 * ExcelDataBCImpl.java
	 * @author Jeong-Hoon, KIM
	 * @see 
	 * @since J2SE 1.6
	 * 2016. 1. 11.
	 */
	private static class ManilaManifestListCondVO extends AbstractValueObject {

		private static final long serialVersionUID = 1L;
		protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

		private Collection<ManilaManifestListCondVO> models = new ArrayList<ManilaManifestListCondVO>();

		/* Status */
		private String ibflag = null;
		/* Column Info */
		private String vslCd = null;
		/* Column Info */
		private String polCd = null;
		/* Column Info */
		private String podCd = null;
		/* Column Info */
		private String regNo = null;
		/* Column Info */
		private String skdDirCd = null;
		/* Column Info */
		private String skdVoyNo = null;
		/* Page Number */
		private String pagerows = null;

		/* hashColumnInpo */
		private HashMap<String, String> hashColumns = new HashMap<String, String>();

		/* hashFildInpo */
		private HashMap<String, String> hashFields = new HashMap<String, String>();

		/**
		 * 
		 * It's Constructor
		 * @author Jeong-Hoon, KIM
		 */
		public ManilaManifestListCondVO() {
		}

		/**
		 * 
		 * It's Constructor
		 * @author Jeong-Hoon, KIM
		 * @param ibflag
		 * @param pagerows
		 * @param vslCd
		 * @param skdVoyNo
		 * @param skdDirCd
		 * @param polCd
		 * @param regNo
		 * @param podCd
		 */
		public ManilaManifestListCondVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String regNo,
				String podCd) {
			this.ibflag = ibflag;
			this.vslCd = vslCd;
			this.polCd = polCd;
			this.podCd = podCd;
			this.regNo = regNo;
			this.skdDirCd = skdDirCd;
			this.skdVoyNo = skdVoyNo;
			this.pagerows = pagerows;
		}

		/**
		 * 
		 */
		public HashMap<String, String> getColumnValues() {
			this.hashColumns.put("ibflag", getIbflag());
			this.hashColumns.put("vsl_cd", getVslCd());
			this.hashColumns.put("pol_cd", getPol());
			this.hashColumns.put("pod_cd", getPod());
			this.hashColumns.put("reg_no", getRegNo());
			this.hashColumns.put("skd_dir_cd", getSkdDirCd());
			this.hashColumns.put("skd_voy_no", getSkdVoyNo());
			this.hashColumns.put("pagerows", getPagerows());
			return this.hashColumns;
		}

		/**
		 * 
		 */
		public HashMap<String, String> getFieldNames() {
			this.hashFields.put("ibflag", "ibflag");
			this.hashFields.put("vsl_cd", "vslCd");
			this.hashFields.put("pol_cd", "polCd");
			this.hashFields.put("pod_cd", "podCd");
			this.hashFields.put("skd_dir_cd", "skdDirCd");
			this.hashFields.put("skd_voy_no", "skdVoyNo");
			this.hashFields.put("pagerows", "pagerows");
			return this.hashFields;
		}

		/**
		 * 
		 * getIbflag
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getIbflag() {
			return this.ibflag;
		}

		/**
		 * 
		 * getVslCd
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getVslCd() {
			return this.vslCd;
		}

		/**
		 * 
		 * getPol
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getPol() {
			return this.polCd;
		}
		
		/**
		 * 
		 * getPod
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getPod() {
			return this.podCd;
		}

		/**
		 * 
		 * getSkdDirCd
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getSkdDirCd() {
			return this.skdDirCd;
		}
		
		/**
		 * 
		 * getSkdVoyNo
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getSkdVoyNo() {
			return this.skdVoyNo;
		}

		/**
		 * 
		 * getPagerows
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getPagerows() {
			return this.pagerows;
		}

		/**
		 * 
		 * getRegNo
		 * @author Jeong-Hoon, KIM
		 * @return String
		 */
		public String getRegNo() {
			return this.regNo;
		}
		
		/**
		 * 
		 * setIbflag
		 * @author Jeong-Hoon, KIM
		 * @param ibflag void
		 */
		public void setIbflag(String ibflag) {
			this.ibflag = ibflag;
			// this.ibflag=true;
		}

		/**
		 * 
		 * setVslCd
		 * @author Jeong-Hoon, KIM
		 * @param vslCd void
		 */
		public void setVslCd(String vslCd) {
			this.vslCd = vslCd;
			// this.vslCd=true;
		}

		/**
		 * 
		 * setPol
		 * @author Jeong-Hoon, KIM
		 * @param polCd void
		 */
		public void setPol(String polCd) {
			this.polCd = polCd;
			// this.clptSeq=true;
		}

		/**
		 * 
		 * setPod
		 * @author Jeong-Hoon, KIM
		 * @param podCd void
		 */
		public void setPod(String podCd) {
			this.podCd = podCd;
			// this.clptSeq=true;
		}

		/**
		 * 
		 * setRegNo
		 * @author Jeong-Hoon, KIM
		 * @param regNo void
		 */
		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		/**
		 * 
		 * setSkdDirCd
		 * @author Jeong-Hoon, KIM
		 * @param skdDirCd void
		 */
		public void setSkdDirCd(String skdDirCd) {
			this.skdDirCd = skdDirCd;
			// this.skdDirCd=true;
		}

		/**
		 * 
		 * setSkdVoyNo
		 * @author Jeong-Hoon, KIM
		 * @param skdVoyNo void
		 */
		public void setSkdVoyNo(String skdVoyNo) {
			this.skdVoyNo = skdVoyNo;
			// this.skdVoyNo=true;
		}

		/**
		 * 
		 * setPagerows
		 * @author Jeong-Hoon, KIM
		 * @param pagerows void
		 */
		public void setPagerows(String pagerows) {
			this.pagerows = pagerows;
			// this.pagerows=true;
		}

		/**
		 * 
		 * fromRequest
		 * @author Jeong-Hoon, KIM
		 * @param request void
		 */
		public void fromRequest(HttpServletRequest request) {
			setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
			setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
			setPol(JSPUtil.getParameter(request, "pol_cd", ""));
			setPod(JSPUtil.getParameter(request, "pod_cd", ""));
			setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
			setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
			setRegNo(JSPUtil.getParameter(request, "reg_no", ""));
			setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		}

		/**
		 * 
		 * fromRequestGrid
		 * @author Jeong-Hoon, KIM
		 * @param request
		 * @return ManilaManifestListCondVO[]
		 */
		public ManilaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
			return fromRequestGrid(request, "");
		}

		/**
		 * 
		 * fromRequestGrid
		 * @author Jeong-Hoon, KIM
		 * @param request
		 * @param prefix
		 * @return ManilaManifestListCondVO[]
		 */
		public ManilaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
			ManilaManifestListCondVO model = null;

			String[] tmp = request.getParameterValues(prefix + "ibflag");
			if (tmp == null)
				return null;

			int length = request.getParameterValues(prefix + "ibflag").length;

			try {
				String[] ibflags = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
				String[] vslCds = (JSPUtil.getParameter(request, prefix + "vsl_cd".trim(), length));
				String[] pols = (JSPUtil.getParameter(request, prefix + "pol_cd".trim(), length));
				String[] pods = (JSPUtil.getParameter(request, prefix + "pod_cd".trim(), length));
				String[] skdDirCds = (JSPUtil.getParameter(request, prefix + "skd_dir_cd".trim(), length));
				String[] skdVoyNos = (JSPUtil.getParameter(request, prefix + "skd_voy_no".trim(), length));
				String[] regNos = (JSPUtil.getParameter(request, prefix + "reg_no".trim(), length));
				String[] pagerowses = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

				for (int i = 0; i < length; i++) {
					model = new ManilaManifestListCondVO();
					if (ibflags[i] != null)
						model.setIbflag(ibflags[i]);
					if (vslCds[i] != null)
						model.setVslCd(vslCds[i]);
					if (pols[i] != null)
						model.setPol(pols[i]);
					if (pods[i] != null)
						model.setPod(pods[i]);
					if (skdDirCds[i] != null)
						model.setSkdDirCd(skdDirCds[i]);
					if (regNos[i] != null)
						model.setRegNo(regNos[i]);
					if (skdVoyNos[i] != null)
						model.setSkdVoyNo(skdVoyNos[i]);
					if (pagerowses[i] != null)
						model.setPagerows(pagerowses[i]);
					models.add(model);
				}

			} catch (Exception e) {
				log.error(e.getMessage());
			}
			return getManilaManifestListCondVOs();
		}

		/**
		 * 
		 * getManilaManifestListCondVOs
		 * @author Jeong-Hoon, KIM
		 * @return ManilaManifestListCondVO[]
		 */
		public ManilaManifestListCondVO[] getManilaManifestListCondVOs() {
			ManilaManifestListCondVO[] vos = (ManilaManifestListCondVO[]) models.toArray(new ManilaManifestListCondVO[models.size()]);
			return vos;
		}

		/**
		 * 
		 */
		public String toString() {
			StringBuffer ret = new StringBuffer();
			Field[] field = this.getClass().getDeclaredFields();
			String space = "";
			try {
				for (int i = 0; i < field.length; i++) {
					String[] arr = null;
					arr = getField(field, i);
					if (arr != null) {
						for (int j = 0; j < arr.length; j++) {
							ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
						}
					} else {
						ret.append(field[i].getName() + " =  null \n");
					}
				}
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
			return ret.toString();
		}

		/**
		 * 
		 * getField
		 * @author Jeong-Hoon, KIM
		 * @param field
		 * @param i
		 * @return String[]
		 */
		private String[] getField(Field[] field, int i) {
			String[] arr = null;
			try {
				arr = (String[]) field[i].get(this);
			} catch (Exception ex) {
				log.error(ex.getMessage());
				arr = getFieldCatct(field, i, arr);
			}
			return arr;
		}

		/**
		 * 
		 * getFieldCatct
		 * @author Jeong-Hoon, KIM
		 * @param field
		 * @param i
		 * @param arr
		 * @return String[]
		 */
		private String[] getFieldCatct(Field[] field, int i, String[] arr) {
			try {
				arr = new String[1];
				arr[0] = String.valueOf(field[i].get(this));
			} catch (IllegalAccessException e) {
				log.error(e.getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
			return arr;
		}

		/**
		 * 
		 * onDataFormat
		 * @author Jeong-Hoon, KIM void
		 */
		public void onDataFormat() {
			this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.regNo = this.regNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		}
	}
}
